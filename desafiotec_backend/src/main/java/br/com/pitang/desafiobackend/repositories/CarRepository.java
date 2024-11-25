package br.com.pitang.desafiobackend.repositories;

import br.com.pitang.desafiobackend.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * criação de classe repository da entidade Carro.
 * */

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
