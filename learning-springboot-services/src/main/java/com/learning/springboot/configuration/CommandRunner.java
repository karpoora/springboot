package com.learning.springboot.configuration;

import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by krvh271 on 9/17/17.
 */
@Component
@Order(1)
public class CommandRunner implements CommandLineRunner {
    private static final Logger logger= Logger.getLogger(CommandRunner.class);
    @Override
    public void run(String... strings) throws Exception {
        logger.info("In CommandRunner Run method."+strings);
    }
}
