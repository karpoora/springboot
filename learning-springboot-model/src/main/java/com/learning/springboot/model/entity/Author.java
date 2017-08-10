package com.learning.springboot.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 * Created by krvh271 on 8/10/17.
 */

@Entity
@Data
public class Author extends ApplicationAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
