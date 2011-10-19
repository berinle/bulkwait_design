package com.jrock.bulkwait.repository;

import com.jrock.bulkwait.domain.Bubble;

/**
 * @author berinle
 */
public interface BubbleRepository {
    Long add(Bubble bubble);
    boolean delete(long bubbleId);
}
