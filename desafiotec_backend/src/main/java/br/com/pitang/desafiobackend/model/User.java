package br.com.pitang.desafiobackend.model;


import br.com.pitang.desafiobackend.enumerats.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
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
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id_user")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String firstName;
    @Column(name = "sobrenome", nullable = false)
    private String lastName;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "aniversario", nullable = false)
    private Date birthday;
    @Column(name = "login", nullable = false)
    private String login;
    @Column(name = "senha", nullable = false)
    private String password;

    private String phone;
    @Column(name = "perfil", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Basic(optional = false)
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDate createAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Car> cars;

    public User(String firstName, String lastName, String email, Date birthday, String login, String password, String phone, UserRole role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthday = birthday;
        this.login = login;
        this.password = password;
        this.phone = phone;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMIN)
            return List.of(new SimpleGrantedAuthority("ADMIN"),
                    new SimpleGrantedAuthority("GESTOR"),
                    new SimpleGrantedAuthority("USER"));
        else return List.of(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {
        return "password";
    } // Retorna a credencial do usuário que criamos anteriormente

    @Override
    public String getUsername() {
        return "login";
    } // Retorna o nome de usuário do usuário que criamos anteriormente

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
