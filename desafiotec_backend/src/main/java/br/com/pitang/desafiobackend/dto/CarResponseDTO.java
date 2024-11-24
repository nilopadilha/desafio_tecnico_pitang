package br.com.pitang.desafiobackend.dto;

import br.com.pitang.desafiobackend.model.Car;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CarResponseDTO {
    private Long id;
    @Size(min = 4, message = "O campo car_year deve ter no minimo 4 caracteres")
    @NotBlank(message = "campo não pode ser vazio")
    @Column(name = "caryear")
    private int car_Year;
    private String licensePlate;
    private String model;
    private String color;
    private Integer quantUsuario;


    public CarResponseDTO(Car car) {
        id = car.getId();
        car_Year = getCar_Year();
        licensePlate = getLicensePlate();
        model = getModel();
        color = getColor();
        quantUsuario = getQuantUsuario();
    }
}
