package br.com.pitang.desafiobackend.exceptions;

/*
* classe que trata os erros do sistemas
* */

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
