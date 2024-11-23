package br.com.pitang.desafiobackend.services.impl;

import br.com.pitang.desafiobackend.dto.UserDTO;
import br.com.pitang.desafiobackend.dto.UserResgistroResponseDTO;
import br.com.pitang.desafiobackend.dto.UserResponseDTO;
import br.com.pitang.desafiobackend.repositories.UserRepository;
import br.com.pitang.desafiobackend.services.CarService;
import br.com.pitang.desafiobackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private CarService carService;

    @Override
    public Page<UserResponseDTO> findAllPaged(Pageable pageable) {
        return null;
    }

    @Override
    public UserResgistroResponseDTO create(UserDTO userRequestDTO) {
        return null;
    }

    @Override
    public UserResponseDTO findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public UserResponseDTO update(Long id, UserDTO userRequestDTO) {
        return null;
    }

    @Override
    public UserResponseDTO findAuthenticateUser(String token) {
        return null;
    }

    @Override
    public void validateAtributtes(UserDTO userRequestDTO) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
