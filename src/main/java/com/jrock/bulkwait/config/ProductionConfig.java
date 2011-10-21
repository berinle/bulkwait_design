package com.jrock.bulkwait.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.jms.ConnectionFactory;
import javax.sql.DataSource;

/**
 * @author berinle
 */
@Configuration
@Profile("prod")
public class ProductionConfig {
    @Bean
    public ConnectionFactory connectionFactory(){
       return new ActiveMQConnectionFactory("tcp://localhost:61616");
    }

    @Bean
    public DataSource dataSource(){
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .build();

    }

}
