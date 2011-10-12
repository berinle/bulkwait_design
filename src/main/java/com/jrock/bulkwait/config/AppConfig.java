package com.jrock.bulkwait.config;

import com.jrock.bulkwait.activemq.Consumer;
import com.jrock.bulkwait.activemq.Producer;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;

/**
 * @author berinle
 */
@Configuration
@Profile("dev")
public class AppConfig {

    @Bean
    public ConnectionFactory connectionFactory(){
       return new ActiveMQConnectionFactory("tcp://localhost:61616");
    }

    @Bean
    public Queue luceneQueue(){
        return new ActiveMQQueue("ERAS.Lucene.Queue");
    }

    @Bean
    public Producer producer(){
        Producer producer = new Producer();
        producer.setJmsTemplate(jmsTemplate());
        return producer;
    }

    @Bean
    public Consumer consumer(){
        return new Consumer(jmsTemplate());
    }

    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setDefaultDestination(luceneQueue());
        jmsTemplate.setConnectionFactory(connectionFactory());
        return jmsTemplate;
    }
}
