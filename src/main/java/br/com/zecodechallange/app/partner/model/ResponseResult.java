package br.com.zecodechallange.app.partner.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@Builder
public class ResponseResult<T> {

    private Integer page;
    private Integer size;
    private Integer totalElements;
    private T result;
    
}
