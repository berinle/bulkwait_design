package com.jrock.bulkwait.service;

import com.jrock.bulkwait.domain.Bubble;
import com.jrock.bulkwait.repository.BubbleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author berinle
 */
@Service
@Transactional
public class BubbleServiceImpl implements BubbleService {
    @Autowired
    private BubbleRepository repository;

    public Long add(Bubble bubble) {
        return repository.add(bubble);
    }
}
