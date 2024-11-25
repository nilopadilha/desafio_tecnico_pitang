package br.com.pitang.desafiobackend.services;

import br.com.pitang.desafiobackend.dto.UserResponseDTO;
import br.com.pitang.desafiobackend.exceptions.ResourceNotFoundException;
import br.com.pitang.desafiobackend.model.User;
import br.com.pitang.desafiobackend.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional(readOnly = true)
    public UserResponseDTO findById(Long id) {
        return new UserResponseDTO(repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado")));
    }

    @Transactional(readOnly = true)
    public Page<UserResponseDTO> findAll(Pageable pageable) {
        Page<User> result = repository.findAll(pageable);
        return result.map(UserResponseDTO::new);
    }

    @Transactional
    public UserResponseDTO insert(UserResponseDTO dto) {
        User entity = new User();
        passDtoToEntity(dto, entity);
        return new UserResponseDTO(repository.save(entity));
    }

    @Transactional
    public UserResponseDTO update(Long id, UserResponseDTO dto) {
        try {
            User entity = repository.getReferenceById(id);
            passDtoToEntity(dto, entity);
            return new UserResponseDTO(repository.save(entity));
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        } else {
            repository.deleteById(id);
        }
    }

    private void passDtoToEntity(UserResponseDTO dto, User entity) {
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setBirthday(dto.getBirthday());
        entity.setLogin(dto.getLogin());
        entity.setPassword(dto.getPassword());
        entity.setPhone(dto.getPhone());
        entity.setRole(dto.getRole());
    }
}
