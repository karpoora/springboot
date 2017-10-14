package com.learning.springboot.model.repository.custom;

import com.learning.springboot.model.entity.Book;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;

public class FlushingBulkOperations implements BulkOperations {

  private final EntityManager em;

  private final int batchSize;

  public FlushingBulkOperations(EntityManager em, int batchSize) {
    this.em = em;
    this.batchSize = batchSize;
  }

  @Override
  @Transactional
  public void bulkPersist(List<Book> books) {
    int i = 0;
    for (Book book : books) {
      em.persist(book);
      i++;

      if (i % batchSize == 0) {
        flush();
        clear();
      }
    }
  }

  private void flush() {
    em.flush();
  }

  private void clear() {
    em.clear();
  }

}
