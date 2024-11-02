package br.com.pitang.desafiobackend.exceptions;

/*
* classe que trata os erros do sistemas
* */

public class UserCarNotFoundException extends RuntimeException{
    public UserCarNotFoundException(String message) {
        super(message);
    }
}
