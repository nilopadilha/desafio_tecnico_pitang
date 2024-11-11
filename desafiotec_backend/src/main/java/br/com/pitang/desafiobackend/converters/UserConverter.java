package br.com.pitang.desafiobackend.converters;

import br.com.pitang.desafiobackend.dto.UserDTO;
import br.com.pitang.desafiobackend.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/*
 * converte DTO para entidadade e vice versa
 * */

@Component
@RequiredArgsConstructor
public class UserConverter {

    private final CarConverter carConverter;


    /**
     * Converte um UserDTO em uma entidade User.     *
     *
     * @param dto o UserDTO a ser convertido.
     * @return a entidade User convertida ou null se o DTO for nulo.
     */
    public User toEntity(UserDTO dto) {
        return Optional.ofNullable(dto).map(d -> {
            User user = new User();
            user.setId(d.getId());
            user.setFirstName(d.getFirstName());
            user.setLastName(d.getLastName());
            user.setLogin(d.getLogin());
            user.setPassword(d.getPassword()); // using helper method
            user.setBirthday(d.getBirthday());
            user.setEmail(d.getEmail());
            user.setPhone(d.getPhone());
            user.setCreateAt(d.getCreateAt());
            user.setCars(Optional.ofNullable(d.getCars()).map(carConverter::toEntity).orElse(null));
            return user;
        }).orElse(null);
    }

    /**
     * Converte a entidade User em um UserDTO.     *
     *
     * @param user a entidade User a ser convertida.
     * @return o UserDTO convertido.
     */
    public UserDTO toDTO(User user) {
        if (user == null) {
            return null;
        }
        return UserDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .login(user.getLogin())
                .email(user.getEmail())
                .birthday(user.getBirthday())
                .phone(user.getPhone())
                .cars(carConverter.toDTO(user.getCars()))
                .createAt(user.getCreateAt())
                .build();
    }

    /**
     * Converte uma lista de entidades de Usuário em uma lista de UserDTOs.     *
     *
     * @param users a lista de entidades de Usuário a serem convertidas.
     * @return a lista de UserDTOs convertidos.
     */
    public List<UserDTO> toDTO(List<User> users) {
        return Optional.ofNullable(users)
                .map(list -> list.stream().map(this::toDTO).collect(Collectors.toList()))
                .orElse(null);
    }

    /**
     * Converte uma lista de UserDTOs em uma lista de entidades User.     *
     *
     * @param dtos a lista de UserDTOs a converter.
     * @return a lista de entidades User convertidas.
     */
    public List<User> toEntity(List<UserDTO> dtos) {
        return Optional.ofNullable(dtos)
                .map(list -> list.stream().map(this::toEntity).collect(Collectors.toList()))
                .orElse(null);
    }


}
