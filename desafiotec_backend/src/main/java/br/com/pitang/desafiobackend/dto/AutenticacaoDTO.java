package br.com.pitang.desafiobackend.dto;

public record AutenticacaoDTO(String login, String password) {

    @Override
    public String toString() {
        return "AutenticacaoDTO{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
