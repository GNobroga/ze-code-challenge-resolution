package br.com.zecodechallange.app.exception;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Getter
@Setter
public class ResponseError {
    private String title;
    private int statusCode;
    private String message;
    private Map<String, String> errors;
}
