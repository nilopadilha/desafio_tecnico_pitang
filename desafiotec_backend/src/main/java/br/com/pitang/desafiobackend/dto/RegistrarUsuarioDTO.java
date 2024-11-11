package br.com.pitang.desafiobackend.dto;

import br.com.pitang.desafiobackend.enumerats.UserRole;

import java.time.LocalDate;

public record RegistrarUsuarioDTO(String firstName, String lastName, String email, LocalDate birthday, String login, String password, String phone, UserRole role) {

}
