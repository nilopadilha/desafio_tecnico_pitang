package br.com.pitang.desafiobackend.dto;

public record AutenticacaoDTO(String login, String senha) {

    @Override
    public String toString() {
        return "autenticacaoDTO[" +
                "login=" + login + ", " +
                "senha=" + senha + ']';
    }
}
