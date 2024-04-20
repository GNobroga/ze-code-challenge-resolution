package br.com.zecodechallange.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ApplicationException extends RuntimeException {
    
    public ApplicationException(String message) {
        super(message, null, true, false);
    }
}
