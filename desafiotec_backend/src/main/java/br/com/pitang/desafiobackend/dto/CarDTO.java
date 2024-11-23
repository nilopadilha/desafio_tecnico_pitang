package br.com.pitang.desafiobackend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDTO {

    private int car_Year;
    private String licensePlate;
    private String model;
    private String color;
    private Integer quantUsuario;

    @Override
    public String toString() {
        return "CarDTO{" +
                "car_Year=" + car_Year +
                ", licensePlate='" + licensePlate + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", quantUsuario=" + quantUsuario +
                '}';
    }
}
