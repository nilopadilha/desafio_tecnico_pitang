package br.com.pitang.desafiobackend.converters;

import br.com.pitang.desafiobackend.dto.UserDTO;
import br.com.pitang.desafiobackend.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


/*
 * converte DTO para entidadade e vice versa
 * */

@Component
@RequiredArgsConstructor
public class UserConverter {

    private final CarConverter carConverter;


    public User toEntity(UserDTO dto) {
        if (Objects.isNull(dto)) {
            return null;
        }
        User e = new User();
        e.setId(dto.getId());
        e.setFirstName(dto.getFirstName());
        e.setLastName(dto.getLastName());
        e.setLogin(dto.getLogin());
        e.setPassword(Objects.nonNull(dto.getPassword()) ? new BCryptPasswordEncoder().encode(dto.getPassword()) : null);
        e.setBirthday(dto.getBirthday());
        e.setEmail(dto.getEmail());
        e.setPhone(dto.getPhone());
        e.setCreateAt(dto.getCreateAt());
        if (Objects.nonNull(dto.getCars())) {
            e.setCars(carConverter.toEntity(dto.getCars()));
        }

        return e;
    }

    public UserDTO toDTO(User user) {
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

    public List<UserDTO> toDTO(List<User> list) {
        return list.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<User> toEntity(List<UserDTO> list) {
        return list.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
