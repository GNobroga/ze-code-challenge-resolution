package br.com.zecodechallange.app.exception;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        HashMap<String, String> errors = new HashMap<>();
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        for (FieldError fieldError : fieldErrors) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ResponseError responseError = ResponseError.builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .title("Argument not Valid")
                .errors(errors)
                .build();

        return ResponseEntity.badRequest().body(responseError);
    }

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<Object> handleApplicationException(ApplicationException ex) {
        var responseErrorBuilder = ResponseError.builder()
                .title("Invalid Information")
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage());
        return ResponseEntity.badRequest().body(responseErrorBuilder.build());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception ex) {
        var responseErrorBuilder = ResponseError.builder()
                .title("Intern Error")
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("Sorry, an internal error has occurred");
        return ResponseEntity.internalServerError().body(responseErrorBuilder.build());
    }

}
