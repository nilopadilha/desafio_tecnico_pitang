package br.com.pitang.desafiobackend.services;


import br.com.pitang.desafiobackend.dto.CarDTO;
import br.com.pitang.desafiobackend.dto.CarResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarService {
    Page<CarResponseDTO> findAllPaged(String token, Pageable pageable);

    CarResponseDTO findById(String token, Long id);

    void delete(String token, Long id);

    CarResponseDTO update(String token, Long id, CarDTO carDtoRequest);

    CarResponseDTO create(String token, CarDTO carDtoRequest);

    boolean existsByLicensePlate(String licensePlate);

    void validateAtributtes(CarDTO carDtoRequest);

    void deleteAll();
}
