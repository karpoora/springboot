package com.learning.springboot.model.entity;

import com.learning.springboot.model.BookType;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;
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

    @Size(min=2,message = "Minimum size is 2 char")
    private String name;
    private String isbn;
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<Author> author;

    @Enumerated(EnumType.STRING)
    private BookType bookType;

//    @Type(type = "yes_no")
    private boolean isAvailable = true;
    private Integer pages;
    private Integer rating;
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<Comment> comments;

}
