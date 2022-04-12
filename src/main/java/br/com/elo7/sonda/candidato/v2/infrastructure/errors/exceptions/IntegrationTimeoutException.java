package br.com.elo7.sonda.candidato.v2.infrastructure.errors.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.GATEWAY_TIMEOUT)
public class IntegrationTimeoutException extends RuntimeException {

    public IntegrationTimeoutException(Exception e) {
        super(e.getMessage());
    }

}
