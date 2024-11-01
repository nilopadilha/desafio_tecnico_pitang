package br.com.pitang.desafiobackend.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CarResponseDTO {

    private int car_year;
    private String licensePlate;
    private String model;
    private String color;
    private Integer quant_usuario;
}
