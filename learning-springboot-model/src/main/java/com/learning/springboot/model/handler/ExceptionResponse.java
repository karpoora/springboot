package com.learning.springboot.model.handler;

import java.util.Date;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Created by krvh271 on 12/24/17.
 */
@Data
@Component
public class ExceptionResponse {
    private Date happendedAt;
    private String message;
    private String description;
}
