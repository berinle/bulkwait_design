package com.jrock.bulkwait;

import com.jrock.bulkwait.activemq.Consumer;
import com.jrock.bulkwait.activemq.Producer;
import com.jrock.bulkwait.config.AppConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

/**
 * @author berinle
 */
public class DummyTest {

    AnnotationConfigApplicationContext ctx = null;

    @Before
    public void setUp() throws Exception {
        ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setDefaultProfiles("dev");
        ctx.register(AppConfig.class);
        ctx.refresh();
    }

    @Test
    public void test_bean_setup() throws Exception {
        assertThat(ctx, notNullValue());
        Producer producer = ctx.getBean(Producer.class);
        assertThat(producer, notNullValue());
    }

    @Test
    public void test_send_message() throws Exception {

        Producer producer = ctx.getBean(Producer.class);
        producer.sendMessage("hello world -- spring 3.1.RC");

    }

    @Test
    public void test_consume_message() throws Exception {
        Consumer consumer = ctx.getBean(Consumer.class);
        consumer.consume("");
    }
}
