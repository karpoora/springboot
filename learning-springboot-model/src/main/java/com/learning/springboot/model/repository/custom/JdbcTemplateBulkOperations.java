package com.learning.springboot.model.repository.custom;

import com.learning.springboot.model.entity.Book;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

public class JdbcTemplateBulkOperations implements BulkOperations {

  private JdbcTemplate template;

  public JdbcTemplateBulkOperations(JdbcTemplate template) {
    this.template = template;
  }

  @Override
  @Transactional
  public void bulkPersist(final List<Book> books) {
    template.batchUpdate("insert into book (ID,IS_AVAILABLE) values (?,?)", new BatchPreparedStatementSetter() {

      @Override
      public void setValues(PreparedStatement ps, int i) throws SQLException {
        ps.setLong(1, books.get(i).getId());
        ps.setBoolean(2,books.get(i).isAvailable());
      }

      @Override
      public int getBatchSize() {
        return books.size();
      }
    });
  }

}
