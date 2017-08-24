package com.learning.springboot;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by krvh271 on 7/28/17.
 */

@SpringBootApplication
@EnableBatchProcessing
//@EnableAZSSO
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class LearnSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(LearnSpringBootApplication.class, args);
    }
}
