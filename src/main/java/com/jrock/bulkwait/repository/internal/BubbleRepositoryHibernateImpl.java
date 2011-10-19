package com.jrock.bulkwait.repository.internal;

import com.jrock.bulkwait.domain.Bubble;
import com.jrock.bulkwait.repository.BubbleRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author berinle
 */
@Repository
public class BubbleRepositoryHibernateImpl implements BubbleRepository {
    @Autowired
    private SessionFactory sessionFactory;
    
    public Long add(Bubble bubble) {
        return (Long) sessionFactory.getCurrentSession().save(bubble);
    }

    public boolean delete(long bubbleId) {

        Session s = sessionFactory.getCurrentSession();
        s.delete(s.load(Bubble.class, bubbleId));
        return true;
    }
}
