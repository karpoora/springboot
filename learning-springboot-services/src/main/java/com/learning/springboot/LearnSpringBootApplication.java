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


// Async execution
// CommandLine execution
// Application Runner
// ThreadPool Execution
// AOP
// Cache
// Batch
// Scheduler
// Log4J2
// Logback-spring
// GlobalException Handler
// Abstract RestHandler
// Auditing - AuditApplicationEvent, ServiceEvent
// ApplicationListener, ServiceListener
// EventPublisher
// Service Versioning in controller
// @Enable-config-service - centralized configuration
// Eureka
// mail
// spring-integration
// kafka
// client load balancing - Ribbon