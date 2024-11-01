package br.com.pitang.desafiobackend.dto;

import br.com.pitang.desafiobackend.enumerats.UserRole;

import java.util.Date;

public record RegistrarUsuarioDTO(String firstName, String lastName, String email, Date birthday, String login, String password, String phone, UserRole role) {

}
