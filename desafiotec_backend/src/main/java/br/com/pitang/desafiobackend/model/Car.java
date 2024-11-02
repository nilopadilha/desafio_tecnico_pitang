package br.com.pitang.desafiobackend.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
public class Car{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id_car")
    private Long id;
    private int car_year;
    private String licensePlate;
    private String model;
    private String color;

    @Column(name = "quant_usuario", columnDefinition = "integer default 0")
    private Integer quantUsuario = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;


}
