package br.com.pitang.desafiobackend.model;


import br.com.pitang.desafiobackend.enumerats.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * @author nilopadilha email.: nilopadilha@gmail
 * classe criada para repesentar em banco e armazenar/persistir os dados de usuarios
 */
@Getter
@Setter
@Entity
@Table(name = "tb_users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id_user")
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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Car> cars;

    public User(String firstname, String lastName, String email, Date birthday, String login, String password, String phone, UserRole role) {
        this.firstName = firstname;
        this.lastName = lastName;
        this.email = email;
        this.birthday = birthday;
        this.login = login;
        this.password = password;
        this.phone = phone;
        this.role = role;

    }
}
