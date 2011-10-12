package com.jrock.bulkwait.activemq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;

/**
 * @author berinle
 */
public class Consumer {
    public static final Logger LOG =  LoggerFactory.getLogger(Consumer.class);

    private JmsTemplate jmsTemplate;

    public Consumer(JmsTemplate jmsTemplate){
        this.jmsTemplate = jmsTemplate;
    }

    public void consume(String message){

        LOG.debug("Consuming message {}", message);
        Object msg = jmsTemplate.receiveAndConvert();

        LOG.debug("Got message, {}", msg);

    }

}
