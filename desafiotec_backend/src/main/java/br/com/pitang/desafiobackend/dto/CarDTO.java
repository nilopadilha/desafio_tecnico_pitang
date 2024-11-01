package br.com.pitang.desafiobackend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CarDTO {
    private Long id;
    private int car_year;
    private String licensePlate;
    private String model;
    private String color;
    private Integer quant_usuario;
}
