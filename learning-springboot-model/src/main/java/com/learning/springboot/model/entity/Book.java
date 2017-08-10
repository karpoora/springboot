package com.learning.springboot.model.entity;

import com.learning.springboot.model.BookType;
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
public class Book extends ApplicationAudit{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String isbn;
    private Author author;
    private BookType bookType;
    private boolean isAvailable = true;
    private Integer pages;
}
