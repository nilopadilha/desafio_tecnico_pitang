package br.com.pitang.desafiobackend.exceptions;

/*
* classe que trata os erros do sistemas
* */

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
