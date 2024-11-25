package br.com.pitang.desafiobackend.dto;

import br.com.pitang.desafiobackend.enumerats.UserRole;
import br.com.pitang.desafiobackend.model.Car;
import br.com.pitang.desafiobackend.model.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDTO {

    private Long id;
    @Size(min = 4, max = 30, message = "O campo firstName deve ter no minimo 4 e no maximo 30 caracteres")
    @NotBlank(message = "campo não pode ser vazio")
    @Column(name = "firstname")
    private String firstName;
    @Size(min = 4, max = 30, message = "O campo firstName deve ter no minimo 4 e no maximo 30 caracteres")
    @NotBlank(message = "campo não pode ser vazio")
    @Column(name = "lastname")
    private String lastName;
    private String email;
    private LocalDate birthday;
    private String login;
    private String password;
    private String phone;
    private UserRole role;
    private List<Car> cars;


    public UserResponseDTO(User user) {
        id = user.getId();
        firstName = user.getFirstName();
        lastName = user.getLastName();
        email = user.getEmail();
        birthday = user.getBirthday();
        login = user.getLogin();
        password = user.getPassword();
        phone = user.getPhone();
        role = user.getRole();
        cars = user.getCars();
    }
}
