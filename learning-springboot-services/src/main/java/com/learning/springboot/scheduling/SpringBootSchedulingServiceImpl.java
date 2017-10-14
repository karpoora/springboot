package com.learning.springboot.scheduling;

import javax.annotation.PostConstruct;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by krvh271 on 10/11/17.
 */
@Component
public class SpringBootSchedulingServiceImpl {

    @Scheduled(cron = "${application.scheduler.cron}")
    public void executeOnScheduled(){
        System.out.println("scheduled");
    }

    @PostConstruct
    public void executeOnStartUp(){
        System.out.println("On Startup");
    }
}
