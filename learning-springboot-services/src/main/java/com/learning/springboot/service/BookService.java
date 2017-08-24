package com.learning.springboot.service;

import com.learning.springboot.model.entity.Book;
import java.util.ArrayList;
import java.util.List;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;

/**
 * Created by krvh271 on 8/10/17.
 */
public interface BookService {
    String addBook(Book book);
    String editBook(Book book);
    List<Book> getBooks();
    Book getBook(Long id);
    String addBooks(ArrayList<Book> books) throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException;
    String deleteBook(Long id);
}
