package com.jrock.bulkwait.domain;

import javax.persistence.*;

/**
 * @author berinle
 */
@Entity
@Table(name="BUBBLE")
public class Bubble {

    @Id
    @Column(name="BUBBLE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySeqGen")
    @SequenceGenerator(name="mySeqGen", sequenceName = "BUBBLE_SEQ")
    private Long id;

    @Column(name="NAME")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
