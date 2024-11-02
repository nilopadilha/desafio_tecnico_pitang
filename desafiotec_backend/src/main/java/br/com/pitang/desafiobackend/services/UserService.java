package br.com.pitang.desafiobackend.services;

import br.com.pitang.desafiobackend.dto.UserDTO;
import br.com.pitang.desafiobackend.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * A classe userservice cria os métodos para usuários no sistema.
 */

@Service
public interface UserService  {

    UserDTO findById(Long id);

    UserDTO update(UserDTO dto);

    UserDTO create(UserDTO dto);

    void deleteById(Long id);

    List<UserDTO> findAll();

    UserDTO findAuthenticateUserByToken(String authorization);

    void deleteCar(Car car);


}
