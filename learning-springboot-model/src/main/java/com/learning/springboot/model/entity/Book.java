package com.learning.springboot.model.entity;

import com.learning.springboot.model.BookType;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

/**
 * Created by krvh271 on 8/10/17.
 */

@Data
@Entity
public class Book extends ApplicationAudit{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String name;
    private String isbn;
    private Author author;
    private BookType bookType;
    private boolean isAvailable = true;
    private Integer pages;
    private Integer rating;
    @OneToMany
    private List<Comment> comments;

}
