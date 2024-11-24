package br.com.pitang.desafiobackend.repositories;

import br.com.pitang.desafiobackend.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
 * criação de classe repository da entidade Carro.
 * */

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Optional<Car> findByIdAndUserId(Long id, Long userId);

    @Query("SELECT c FROM Car c WHERE c.user.id = :userId ORDER BY c.quantUsuario DESC")
    List<Car> findAllByUserIdOrderByquantUsuarioDesc(Long userId);


    boolean existsByLicensePlateAndIdNot(String licensePlate, Long id);


    Page<Car> findByUserId(@Param("userId") Long userId, Pageable pageable);
}
