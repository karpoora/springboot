package com.learning.springboot.model.repository.custom;

import com.learning.springboot.model.entity.Book;
import java.util.List;
import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.IDBI;
import org.skife.jdbi.v2.PreparedBatch;
import org.skife.jdbi.v2.tweak.HandleCallback;
import org.springframework.transaction.annotation.Transactional;

public final class JdbiBulkOperations implements BulkOperations {

  private final IDBI dbi;

  private final int batchSize;

  public JdbiBulkOperations(IDBI dbi, int batchSize) {
    this.dbi = dbi;
    this.batchSize = batchSize;
  }

  @Override
  @Transactional
  public void bulkPersist(final List<Book> books) {
    dbi.withHandle(new HandleCallback<Void>() {
      @Override
      public Void withHandle(Handle handle) {
        String sql = "insert into customer (id) values (?)";

        PreparedBatch preparedBatch = handle.prepareBatch(sql);

        int i = 0;
        for (Book book : books) {
          preparedBatch.add().bind(0, book.getId());
          i++;

          if (i % batchSize == 0) {
            preparedBatch.execute();
            preparedBatch = handle.prepareBatch(sql);
          }
        }

        preparedBatch.execute();

        return null;
      }
    });
  }
}
