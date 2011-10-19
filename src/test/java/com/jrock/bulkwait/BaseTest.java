package com.jrock.bulkwait;

import com.jrock.bulkwait.config.AppConfig;
import org.junit.Before;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author berinle
 */
public class BaseTest {
    protected AnnotationConfigApplicationContext ctx = null;

    @Before
    public void setUp() throws Exception {
        ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setDefaultProfiles("dev");
        ctx.register(AppConfig.class);
        ctx.refresh();
    }
}
