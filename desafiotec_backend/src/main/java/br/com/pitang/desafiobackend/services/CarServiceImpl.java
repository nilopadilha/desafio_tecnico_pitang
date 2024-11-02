package br.com.pitang.desafiobackend.services;

import br.com.pitang.desafiobackend.converters.CarConverter;
import br.com.pitang.desafiobackend.converters.UserConverter;
import br.com.pitang.desafiobackend.dto.CarDTO;
import br.com.pitang.desafiobackend.dto.UserDTO;
import br.com.pitang.desafiobackend.exceptions.UserCarNotFoundException;
import br.com.pitang.desafiobackend.model.Car;
import br.com.pitang.desafiobackend.model.User;
import br.com.pitang.desafiobackend.repositories.CarRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository repository;
    private final CarConverter converter;
    private final UserService userService;
    private final UserConverter userConverter;

    /**
     * Recupera a lista de todos os carros do usuário no sistema.
     */


    @Override
    public List<CarDTO> findAll(String token) throws UserCarNotFoundException {
        UserDTO user = this.userService.findAuthenticateUserByToken(token);
        return this.converter.toDTO(this.repository.findAllByUserIdOrderByQtdUsoDesc(user.getId()));

    }

    /**
     * Recupera um carro do usuário logado por id
     *
     * @param id    do carrro para perquisa
     * @param token para verificação do usuário logado
     */
    @Override
    public CarDTO findById(String token, Long id) throws UserCarNotFoundException {
        UserDTO user = this.userService.findAuthenticateUserByToken(token);
        Car car = this.repository.findByIdAndUserId(id, user.getId())
                .orElseThrow(() -> new UserCarNotFoundException("Entity not found: " + id));

        // Increment quantidade de usuario por 1
        car.setQuant_usuario(car.getQuant_usuario() + 1);
        this.repository.save(car);

        return this.converter.toDTO(car);

    }

    /**
     * Atualiza os dados de um veiculo vinculado a um usuário logado
     *
     * @param dto   objeto com os dados atualizado do veiculo
     * @param token para verificação do usuário logado
     */
    @Override
    @Transactional
    public CarDTO update(String token, CarDTO dto) throws UserCarNotFoundException {
        if (this.repository.existsByLicensePlateAndIdNot(dto.getLicensePlate(), dto.getId())) {
            throw new UserCarNotFoundException("License plate already exists");
        }
        return this.create(token, dto);

    }

    /**
     * cria um novo veiculo vinculado a um usuário logado
     *
     * @param dto   objeto com os dados do novo veiculo cadastrado
     * @param token para verificação do usuário logado
     */
    @Override
    public CarDTO create(String token, CarDTO dto) throws UserCarNotFoundException {
        validationFields(dto);
        Car car = this.converter.toEntity(dto);
        User user = this.userConverter.toEntity(this.userService.findAuthenticateUserByToken(token));
        car.setUser(user);
        return this.converter.toDTO(this.repository.save(car));

    }


    /**
     * Validação de  campos nulos
     *
     * @param dto para verificação dos campos
     */

    private void validationFields(CarDTO dto) {
        if (Objects.isNull(dto.getCar_year()) || dto.getColor().isBlank()
                || dto.getLicensePlate().isBlank() || dto.getModel().isBlank()) {
            throw new UserCarNotFoundException("Missing fields");
        }

    }

    /**
     * deleta um carro vinculado a um usuário logado por id
     *
     * @param id    do carro a ser deletado
     * @param token para verificação do usuário logado
     */
    @Override
    @Transactional
    public void delete(String token, Long id) throws UserCarNotFoundException {
        UserDTO userDTO = this.userService.findAuthenticateUserByToken(token);
        this.repository.findByIdAndUserId(id, userDTO.getId())
                .ifPresent(car -> {
                    this.userService.deleteCar(car);
                    this.repository.delete(car);
                });


    }
}
