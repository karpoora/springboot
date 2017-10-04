package com.learning.springboot.model.entity;

import com.learning.springboot.model.BookType;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Data;

/**
 * Created by krvh271 on 8/10/17.
 */

@Data
@Entity
public class Book{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String name;
    private String isbn;
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<Author> author;
    private BookType bookType;
    private boolean isAvailable = true;
    private Integer pages;
    private Integer rating;
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<Comment> comments;

}
