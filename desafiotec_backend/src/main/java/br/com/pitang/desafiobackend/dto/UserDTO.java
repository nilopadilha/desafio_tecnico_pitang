package br.com.pitang.desafiobackend.dto;

import br.com.pitang.desafiobackend.enumerats.UserRole;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    private String firstName;
    private String lastName;
    private String email;
    private Date birthday;
    private String login;
    private String password;
    private String phone;
    @Column(name = "perfil", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;
    private LocalDate createAt;


    private List<CarDTO> cars;

    public void setCreateAt(LocalDate now) {

    }
}
