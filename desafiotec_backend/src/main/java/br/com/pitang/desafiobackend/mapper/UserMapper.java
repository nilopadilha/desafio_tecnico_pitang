package br.com.pitang.desafiobackend.mapper;

import br.com.pitang.desafiobackend.dto.UserDTO;
import br.com.pitang.desafiobackend.model.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper {

    @Autowired
    private final ModelMapper mapper;


    public  User toEntity(UserDTO dto) {
        return mapper.map(dto, User.class);
    }

    public UserDTO toDTO(User usuario) {
        UserDTO dto = mapper.map(usuario, UserDTO.class);
        return dto;
    }

    public List<UserDTO> toDTO(List<User> usuarios) {
        return usuarios.stream()
                .map(usuario -> toDTO(usuario))
                .collect(Collectors.toList());
    }


    public void updateUsuarioFromDto(UserDTO usuarioDTO, User usuario) {
        if (usuarioDTO == null || usuario == null) {
            return;
        }
        usuario.setFirstName(usuarioDTO.getFirstName());
        usuario.setLastName(usuarioDTO.getLastName());
        usuario.setBirthday(usuarioDTO.getBirthday());
        usuario.setLogin(usuarioDTO.getLogin());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setPhone(usuarioDTO.getPhone());
        usuario.setPassword(usuarioDTO.getPassword());
        usuario.setRole(usuarioDTO.getRole());

    }
}
