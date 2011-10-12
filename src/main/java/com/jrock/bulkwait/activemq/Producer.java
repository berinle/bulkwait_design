package com.jrock.bulkwait.activemq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @author berinle
 */
public class Producer {

    public static final Logger LOG =  LoggerFactory.getLogger(Producer.class);

    private JmsTemplate jmsTemplate;

    public void sendMessage(final String msg){
        LOG.debug("Sending message {}", msg);

        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage();
                textMessage.setText(msg);
                return textMessage;
            }
        });

        LOG.debug("done");

    }


    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
}
