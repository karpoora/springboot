package com.pandian.learning.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * Created by krvh271 on 7/28/17.
 */

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
//@EnableAZSSO
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class LearnSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(LearnSpringBootApplication.class, args);
    }
}
