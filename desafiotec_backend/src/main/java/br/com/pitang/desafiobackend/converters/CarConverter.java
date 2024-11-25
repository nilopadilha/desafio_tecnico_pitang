package br.com.pitang.desafiobackend.converters;

import br.com.pitang.desafiobackend.dto.CarResponseDTO;
import br.com.pitang.desafiobackend.model.Car;
import br.com.pitang.desafiobackend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class CarConverter {

    private final UserRepository userRepository;

    public Car toEntity(CarResponseDTO dto) {
        Car e = new Car();
       e.setId(dto.getId());
        e.setCar_year(dto.getCar_Year());
        e.setColor(dto.getColor());
        e.setModel(dto.getModel());
        e.setLicensePlate(dto.getLicensePlate());
     return  e;
    }

    public CarResponseDTO toDTO(Car car) {
        return CarResponseDTO.builder()
                .id(car.getId())
                .color(car.getColor())
                .car_Year(car.getCar_year())
                .licensePlate(car.getLicensePlate())
                .model(car.getModel())
                .build();
    }

    public List<CarResponseDTO> toDTO(List<Car> list) {
        return list.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<Car> toEntity(List<CarResponseDTO> list) {
        return list.stream().map(this::toEntity).collect(Collectors.toList());
    }

}
