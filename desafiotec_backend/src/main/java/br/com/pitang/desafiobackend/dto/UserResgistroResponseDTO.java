package br.com.pitang.desafiobackend.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserResgistroResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String birthday;
    private String phone;
    private String createdAt;
    private String lastLogin;

    private List<CarResponseDTO> cars = new ArrayList<>();
}
