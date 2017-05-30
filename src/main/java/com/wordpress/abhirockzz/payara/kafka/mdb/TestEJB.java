package com.wordpress.abhirockzz.payara.kafka.mdb;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class TestEJB {
    @PostConstruct
    public void init(){
        System.out.println("Broker --- "+ System.getenv("KAFKA_BROKER")); 
    }
}
