package com.learning.springboot;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by krvh271 on 7/28/17.
 */

@SpringBootApplication
@EnableBatchProcessing
@EnableEurekaClient
//@EnableAZSSO
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class LearnSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(LearnSpringBootApplication.class, args);
    }

    // faster spring boot startup in local environment  ************
    // It enables lazyInit which helps in faster application startup in Local profile
    @Configuration
    @Profile("local")
    @ComponentScan(lazyInit = true)
    static class LocalConfig {
    }
}
// Async execution
// CommandLine execution
// Application Runner
// ThreadPool Execution
// AOP
// Cache
// Scheduler
// Log4J2
// Logback-spring
// GlobalException Handler
// Abstract RestHandler
// Auditing - AuditApplicationEvent, ServiceEvent
// ApplicationListener, ServiceListener
// EventPublisher
// Service Versioning in controller - backward compatibility
// @Enable-config-service - centralized configuration - vault or git
// service Registry and Discovery - Eureka
// circuit breaker - Hystrix.
// mail
// kafka
// client load balancing - Ribbon or Feign
// social - facebook,twitter