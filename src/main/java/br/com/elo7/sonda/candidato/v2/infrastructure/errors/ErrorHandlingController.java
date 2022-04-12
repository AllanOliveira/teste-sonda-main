package br.com.elo7.sonda.candidato.v2.infrastructure.errors;

import br.com.elo7.sonda.candidato.v2.infrastructure.errors.exceptions.NotFoundException;
import br.com.elo7.sonda.candidato.v2.infrastructure.errors.exceptions.ValidationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ErrorHandlingController extends ResponseEntityExceptionHandler {

    public static final String THROWABLE_EXCEPTION = "throwable_exception";

    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(value = NOT_FOUND)
    @ResponseBody
    public ErrorHandlerResult resourceNotFound(final NotFoundException exception, HttpServletRequest request) {
        return new ErrorHandlerResult(request.getRequestURI()).addErrors(exception.getMessage(), NOT_FOUND.value());
    }

    @ExceptionHandler({ValidationException.class})
    @ResponseStatus(value = BAD_REQUEST)
    @ResponseBody
    public ErrorHandlerResult badRequest(final ValidationException exception, HttpServletRequest request) {
        return new ErrorHandlerResult(request.getRequestURI()).addErrors(exception.getErrors().toString(), BAD_REQUEST.value());
    }

}
