package com.learning.springboot.model.repository;

import com.learning.springboot.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by krvh271 on 8/24/17.
 */
@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
