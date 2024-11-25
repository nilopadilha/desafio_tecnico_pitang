package br.com.pitang.desafiobackend.dto;

import br.com.pitang.desafiobackend.enumerats.UserRole;
import br.com.pitang.desafiobackend.model.Car;

import java.time.LocalDate;
import java.util.List;

public record RegistrarUsuarioDTO(String firstName, String lastName, String email, LocalDate birthday, String login, String password, String phone, UserRole role, List<Car> cars) {

}
