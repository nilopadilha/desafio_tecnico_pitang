package br.com.pitang.desafiobackend.services;

import br.com.pitang.desafiobackend.dto.UserDTO;
import br.com.pitang.desafiobackend.dto.UserResgistroResponseDTO;
import br.com.pitang.desafiobackend.dto.UserResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<UserResponseDTO> findAllPaged(Pageable pageable);

    UserResgistroResponseDTO create(UserDTO userRequestDTO);

    UserResponseDTO findById(Long id);

    void delete(Long id);

    UserResponseDTO update(Long id, UserDTO userRequestDTO);

    UserResponseDTO findAuthenticateUser(String token);

    void validateAtributtes(UserDTO userRequestDTO);

    void deleteAll();
}
