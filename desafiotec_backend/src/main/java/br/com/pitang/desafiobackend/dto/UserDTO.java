package br.com.pitang.desafiobackend.dto;

import br.com.pitang.desafiobackend.enumerats.UserRole;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long id;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome", nullable = false)
    private String firstName;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "sobrenome", nullable = false)
    private String lastName;

    @NotNull
    @Email
    @Size(max = 100)
    private String email;

    // Consider using LocalDate instead of Date
    private LocalDate birthday;

    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "login", nullable = false)
    private String login;

    // Set password to private to ensure security; avoid exposing this field
    @Column(name = "password", nullable = false)
    private String password;

    @Size(max = 15)
    private String phone;

    @NotNull
    @Column(name = "perfil", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    private LocalDate createAt = LocalDate.now();

    // Encapsulate the cars list to avoid direct external modifications
    private List<CarDTO> cars = new ArrayList<>();

    // Get a copy of the cars list to maintain encapsulation
    public List<CarDTO> getCars() {
        return new ArrayList<>(cars);
    }

    // Custom toString method for better logging and debugging
    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", login='" + login + '\'' +
                ", phone='" + phone + '\'' +
                ", role=" + role +
                ", createAt=" + createAt +
                '}';
    }



}
