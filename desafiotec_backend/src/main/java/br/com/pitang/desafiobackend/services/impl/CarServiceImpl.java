package br.com.pitang.desafiobackend.services.impl;

import br.com.pitang.desafiobackend.dto.CarDTO;
import br.com.pitang.desafiobackend.dto.CarResponseDTO;
import br.com.pitang.desafiobackend.repositories.CarRepository;
import br.com.pitang.desafiobackend.services.CarService;
import br.com.pitang.desafiobackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository repository;

    @Autowired
    private UserService userService;

    @Override
    public Page<CarResponseDTO> findAllPaged(String token, Pageable pageable) {
        return null;
    }

    @Override
    public CarResponseDTO findById(String token, Long id) {
        return null;
    }

    @Override
    public void delete(String token, Long id) {

    }

    @Override
    public CarResponseDTO update(String token, Long id, CarDTO carDtoRequest) {
        return null;
    }

    @Override
    public CarResponseDTO create(String token, CarDTO carDtoRequest) {
        return null;
    }

    @Override
    public boolean existsByLicensePlate(String licensePlate) {
        return false;
    }

    @Override
    public void validateAtributtes(CarDTO carDtoRequest) {

    }

    @Override
    public void deleteAll() {

    }
}
