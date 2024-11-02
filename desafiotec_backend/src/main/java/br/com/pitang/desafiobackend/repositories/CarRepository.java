package br.com.pitang.desafiobackend.repositories;

import br.com.pitang.desafiobackend.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
* criação de classe repository da entidade Carro.
* */

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Optional<Car> findByIdAndUserId(Long id, Long userId);

    List<Car> findAllByUserIdOrderByQtdUsoDesc(Long userId);

    boolean existsByLicensePlate(String licensePlate);

    boolean existsByLicensePlateAndIdNot(String licensePlate, Long id);


}
