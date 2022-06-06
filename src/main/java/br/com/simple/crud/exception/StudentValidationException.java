package br.com.simple.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.PARTIAL_CONTENT)
public class StudentValidationException extends ServiceErrorException {
    public StudentValidationException(String message) {
        super(message);
    }
}
