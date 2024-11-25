package br.com.pitang.desafiobackend.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 *  @author nilopadilha email.: nilopadilha@gmail
 * classe criada para repesentar em banco de dados e armazenar/persistir os dados de carro
 */
@Getter
@Setter
@Entity
@Table(name = "tb_cars")
@AllArgsConstructor
@NoArgsConstructor
public class Car implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id_car")
    private Long id;
    @Column(name = "anocarro", nullable = false)
    private int car_year;
    @Column(name = "placacarro", nullable = false)
    private String licensePlate;
    @Column(name = "modelo", nullable = false)
    private String model;
    @Column(name = "cor", nullable = false)
    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;


}
