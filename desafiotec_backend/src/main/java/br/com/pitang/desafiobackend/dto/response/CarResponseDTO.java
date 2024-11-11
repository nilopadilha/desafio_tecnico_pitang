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
    private int car_Year; //Convenção de nomenclatura alterada para camelCase

    private String licensePlate;
    private String model;
    private String color;
    private Integer quant_usuario; // Changed naming convention to camelCase


    @Override
    public String toString() {
        return "CarResponseDTO{" +
                "car_Year=" + car_Year +
                ", licensePlate='" + licensePlate + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", quant_usuario=" + quant_usuario +
                '}';
    }

    // Optional: equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarResponseDTO)) return false;

        CarResponseDTO carRespDTO = (CarResponseDTO) o;

        if (car_Year != carRespDTO.car_Year) return false;
        if (!licensePlate.equals(carRespDTO.licensePlate)) return false;
        if (!model.equals(carRespDTO.model)) return false;
        if (!color.equals(carRespDTO.color)) return false;
        return quant_usuario != null ? quant_usuario.equals(carRespDTO.quant_usuario) : carRespDTO.quant_usuario == null;
    }

    @Override
    public int hashCode() {
        int result = car_Year;
        result = 31 * result + licensePlate.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + color.hashCode();
        result = 31 * result + (quant_usuario != null ? quant_usuario.hashCode() : 0);
        return result;
    }
}
