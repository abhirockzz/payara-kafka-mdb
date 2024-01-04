package com.wordpress.abhirockzz.payara.kafka.mdb;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.logging.Level;
import java.util.logging.Logger;

@Singleton
@Startup
public class TestEJB {

    private static final Logger LOGGER = Logger.getLogger(TestEJB.class.getName());

    @PostConstruct
    public void init(){
        LOGGER.log(Level.INFO, "Broker --- " + System.getenv("KAFKA_BROKER"));
    }
}
