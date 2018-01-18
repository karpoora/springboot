package com.learning.springboot.model.repository;

import com.learning.springboot.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by krvh271 on 8/24/17.
 */
@RepositoryRestResource(path = "book-rest")
public interface BookRepository extends JpaRepository<Book,Long> {
}
