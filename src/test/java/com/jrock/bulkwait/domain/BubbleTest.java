package com.jrock.bulkwait.domain;

import com.jrock.bulkwait.BaseTest;
import com.jrock.bulkwait.service.BubbleService;
import com.jrock.bulkwait.service.BubbleServiceImpl;
import org.hamcrest.core.IsNot;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * @author berinle
 */
public class BubbleTest extends BaseTest {

//    @Autowired
//    BubbleRepository repository;
    
    @Test
    public void test_db_insert() throws Exception {
        Bubble bubble = new Bubble();
        bubble.setName("bayo");

        BubbleService service = ctx.getBean(BubbleService.class);

        Long id = service.add(bubble);
        System.out.println(id);
//        assertThat(id, IsNot.not(null));
        assertNotNull(id);

    }
}
