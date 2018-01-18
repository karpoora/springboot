package com.learning.springboot.model.handler;

import lombok.Data;

/**
 * Created by krvh271 on 12/24/17.
 */
@Data
public class NoContentException extends RuntimeException {
    private String message;
    public NoContentException(String message){
        this.message=message;
    }
}
