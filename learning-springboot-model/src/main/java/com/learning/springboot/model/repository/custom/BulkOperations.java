package com.learning.springboot.model.repository.custom;

import com.learning.springboot.model.entity.Book;
import java.util.List;

public interface BulkOperations {

  public void bulkPersist(List<Book> entities);

}
