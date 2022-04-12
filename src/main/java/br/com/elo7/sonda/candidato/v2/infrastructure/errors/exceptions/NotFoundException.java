package br.com.elo7.sonda.candidato.v2.infrastructure.errors.exceptions;

public class NotFoundException extends RuntimeException{

    private static String DEFAULT_MESSAGE = "Element not found.";

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException() {
        super(DEFAULT_MESSAGE);
    }
}
