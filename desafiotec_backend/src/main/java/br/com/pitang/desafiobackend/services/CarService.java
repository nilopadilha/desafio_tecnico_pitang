package br.com.pitang.desafiobackend.services;

import br.com.pitang.desafiobackend.dto.CarDTO;

import java.util.List;
/**
 * A classe carservice cria os métodos para carros no sistema.
 */

public interface CarService {

    List<CarDTO> findAll(String token);

    CarDTO findById(String token, Long id);

    CarDTO update(String token, CarDTO dto);

    CarDTO create(String token, CarDTO dto);

    void delete(String token, Long id);


}
