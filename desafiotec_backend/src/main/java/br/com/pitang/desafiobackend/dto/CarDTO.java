package br.com.pitang.desafiobackend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDTO {
    private Long id;

    @Min(value = 1886, message = "ano não pode ser menor que 1886")
    private int car_Year;

    @NotNull
    @Size(min = 1, max = 15)
    private String licensePlate;

    @NotNull
    @Size(min = 1, max = 50)
    private String model;

    @NotNull
    @Size(min = 1, max = 30)
    private String color;

    @Min(value = 0, message = "A contagem de usuários não deve ser negativa")
    private Integer quantUsuario;


    @Override
    public String toString() {
        return "CarDTO{" +
                "id=" + id +
                ", car_Year=" + car_Year +
                ", licensePlate='" + licensePlate + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", quantUsuario=" + quantUsuario +
                '}';
    }
}
