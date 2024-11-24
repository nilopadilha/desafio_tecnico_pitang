package br.com.pitang.desafiobackend.mapper;

import br.com.pitang.desafiobackend.dto.CarResponseDTO;
import br.com.pitang.desafiobackend.model.Car;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CarMapper {

    @Autowired
    private final ModelMapper mapper;


    public Car toEntity(CarResponseDTO dto) {
        return mapper.map(dto, Car.class);
    }

    public CarResponseDTO toDTO(Car car) {
        CarResponseDTO dto = mapper.map(car, CarResponseDTO.class);
        return dto;
    }

    public List<CarResponseDTO> toDTO(List<Car> cars) {
        return cars.stream()
                .map(car -> toDTO(car))
                .collect(Collectors.toList());
    }

}
