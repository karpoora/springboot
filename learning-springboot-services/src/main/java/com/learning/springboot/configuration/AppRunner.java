package com.learning.springboot.configuration;

import org.apache.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by krvh271 on 9/17/17.
 */
@Component
@Order(2)
public class AppRunner implements ApplicationRunner {
    private static final Logger logger= Logger.getLogger(AppRunner.class);
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        logger.info("In ApplicationRunner Run method."+applicationArguments.getSourceArgs());
    }
}
