package br.com.pitang.desafiobackend.repositories;


import br.com.pitang.desafiobackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;


/*
 * criação de classe repository da entidade Usuario.
 * */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByLogin(String login);
}
