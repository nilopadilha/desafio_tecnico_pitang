package br.com.pitang.desafiobackend.dto;

import br.com.pitang.desafiobackend.enumerats.UserRole;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
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
    @Column(name = "primeironome", nullable = false)
    private String firstName;
    @NotNull
    @Column(name = "ultimonome", nullable = false)
    private String lastName;
    @NotNull
    @Email
    private String email;
    private Date birthday;
    @NotNull
    @Column(name = "login", nullable = false)
    private String login;
    @Column(name = "password", nullable = false)
    private String password;
    private String phone;
    @Column(name = "perfil", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;
    private LocalDate createAt = LocalDate.now();


    private List<CarDTO> cars;


}
