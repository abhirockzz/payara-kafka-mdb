package com.wordpress.abhirockzz.payara.kafka.mdb;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.concurrent.ManagedExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;

@Singleton
@Startup
public class ProducerTrigger {

    private static final Logger LOGGER = Logger.getLogger(ProducerTrigger.class.getName());

    @Resource
    ManagedExecutorService mes;

    @PostConstruct
    public void trigger() {
        mes.execute(new Producer());
        LOGGER.log(Level.INFO, "Producer triggered....");
    }
}
