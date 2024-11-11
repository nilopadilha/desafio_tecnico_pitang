package br.com.pitang.desafiobackend.repositories;


import br.com.pitang.desafiobackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/*
 * criação de classe repository da entidade Usuario.
 * */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByfirstName(String login);

    boolean existsByEmail(String email);

    boolean existsByEmailAndIdNot(String email, Long id);

    boolean existsByLogin(String login);

    UserDetails findByLogin(String login);

    boolean existsByLoginAndIdNot(String login, Long id);
}
