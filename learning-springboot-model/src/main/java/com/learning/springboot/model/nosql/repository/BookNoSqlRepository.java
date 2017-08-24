package com.learning.springboot.model.nosql.repository;

import com.learning.springboot.model.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by krvh271 on 8/15/17.
 */
@Repository
public interface BookNoSqlRepository extends MongoRepository<Book,Long> {
}
