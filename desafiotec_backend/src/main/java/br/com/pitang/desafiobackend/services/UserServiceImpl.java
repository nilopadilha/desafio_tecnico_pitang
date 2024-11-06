package br.com.pitang.desafiobackend.services;


import br.com.pitang.desafiobackend.config.TokenService;
import br.com.pitang.desafiobackend.converters.UserConverter;
import br.com.pitang.desafiobackend.dto.UserDTO;
import br.com.pitang.desafiobackend.exceptions.ResourceNotFoundException;
import br.com.pitang.desafiobackend.model.Car;
import br.com.pitang.desafiobackend.model.User;
import br.com.pitang.desafiobackend.repositories.UserRepository;
import com.auth0.jwt.exceptions.TokenExpiredException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserConverter converter;

    /**
     * Recupera um usuário por id
     *
     * @param id do usuário para perquisa
     */
    @Override
    public UserDTO findById(Long id) {
        return this.converter.toDTO(Objects.requireNonNull(this.repository.findById(id).orElse(new User())));
    }

    /**
     * Atualiza os dados usuário
     *
     * @param dto objeto com os dados atualizado do usuário
     */
    @Override
    @Transactional
    public UserDTO update(UserDTO dto) throws ResourceNotFoundException {
        this.validateUpdateFields(dto);
        return this.save(dto);
    }

    /**
     * Salva um novo usuário
     *
     * @param dto objeto com os dados do novo usuário
     */
    @Override
    @Transactional
    public UserDTO create(UserDTO dto) throws ResourceNotFoundException {
        this.validateFields(dto);
        dto.setCreateAt(LocalDate.now());
        return this.save(dto);
    }

    /**
     * Salva um usuário
     *
     * @param dto objeto com os dados do novo usuário
     */
    public UserDTO save(UserDTO dto) throws ResourceNotFoundException {
        User userEntity = this.converter.toEntity(dto);
        if (Objects.nonNull(userEntity.getId()) && (Objects.isNull(userEntity.getPassword()))) {
            userEntity.setPassword(this.repository.findById(dto.getId())
                    .orElse(new User()).getPassword());

        }
        this.validateFieldsIsNull(userEntity);
        return this.converter.toDTO(this.repository.save(userEntity));
    }

    /**
     * Exclui um usuário por id
     *
     * @param id do usuário a ser excluído
     */
    @Override
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

    /**
     * Recupera a lista de todos os usuários
     */
    @Override
    public List<UserDTO> findAll() {
        return this.converter.toDTO(this.repository.findAll());
    }

    /**
     * Valida e existência de algum usuário com o e-mail ou login informado
     *
     * @param dto para verificação dos campos
     */
    private void validateFields(UserDTO dto) throws ResourceNotFoundException {
        if (this.repository.existsByEmail(dto.getEmail())) {
            throw new ResourceNotFoundException("Email already exists");
        }
        if (this.repository.existsByLogin(dto.getLogin())) {
            throw new ResourceNotFoundException("Login already exists");
        }
    }

    /**
     * Valida e existência de algum usuário com o e-mail ou login informado
     *
     * @param dto para verificação dos campos
     */
    private void validateUpdateFields(UserDTO dto) throws ResourceNotFoundException {
        if (this.repository.existsByEmailAndIdNot(dto.getEmail(), dto.getId())) {
            throw new ResourceNotFoundException("Email already exists");
        }
        if (this.repository.existsByLoginAndIdNot(dto.getLogin(), dto.getId())) {
            throw new ResourceNotFoundException("Login already exists");
        }
    }

    /**
     * Retorna os dados do usuário a partir dos token JWT
     *
     * @param authorization para extração do token
     */
    @Override
    public UserDTO findAuthenticateUserByToken(String authorization) {

        String token = authorization.replace("Bearer ", Strings.EMPTY);
        if (token.isBlank()) {
            throw new ResourceNotFoundException("Unauthorized");
        }

        try {
            TokenService jwt = new TokenService();
            String login = jwt.validateToken(token);
            User user = this.repository.findByFirstName(login).orElse(new User());
            return this.converter.toDTO(user);
        } catch (TokenExpiredException e) {
            throw new ResourceNotFoundException("Unauthorized - invalid session");
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error: " + e.getMessage());
        }
    }


    /**
     * deletar um veiculo do usuário
     *
     * @param car - carro a ser removido
     */
    @Override
    @Transactional
    public void deleteCar(Car car) {
        this.repository.findById(car.getUser().getId())
                .ifPresent(user -> {
                    user.getCars().remove(car);
                    this.repository.save(user);
                });
    }

    /**
     * Validação de campos nulos
     *
     * @param dto para verificação dos campos
     */
    private void validateFieldsIsNull(User dto) throws ResourceNotFoundException {
        if (Objects.isNull(dto.getBirthday()) || dto.getFirstName().isBlank()
                || dto.getLastName().isBlank() || dto.getEmail().isBlank()
                || dto.getLogin().isBlank() || dto.getPassword().isBlank()
                || dto.getPhone().isBlank()) {
            throw new ResourceNotFoundException("Missing fields");
        }
    }

}
