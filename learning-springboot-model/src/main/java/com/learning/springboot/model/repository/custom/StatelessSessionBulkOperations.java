package com.learning.springboot.model.repository.custom;

import com.learning.springboot.model.entity.Book;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.StatelessSession;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

public class StatelessSessionBulkOperations implements BulkOperations {

  private final StatelessSession statelessSession;

  public StatelessSessionBulkOperations(EntityManager em, StatelessSession statelessSession) {
    this.statelessSession = statelessSession;
  }

  @Override
  @Transactional
  public void bulkPersist(List<Book> books) {
    for (Book book : books) {
      statelessSession.insert(book);
    }
  }

}
