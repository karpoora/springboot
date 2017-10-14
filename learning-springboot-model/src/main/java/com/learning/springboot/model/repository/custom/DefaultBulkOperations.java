package com.learning.springboot.model.repository.custom;

import com.learning.springboot.model.entity.Book;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DefaultBulkOperations implements BulkOperations {

  private final EntityManager em;

  public DefaultBulkOperations(EntityManager em) {
    this.em = em;
  }

  @Override
  @Transactional
  public void bulkPersist(List<Book> books) {
    for (Book book : books) {
      em.persist(book);
    }
  }

}
