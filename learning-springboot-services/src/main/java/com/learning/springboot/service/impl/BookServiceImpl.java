package com.learning.springboot.service.impl;

import com.learning.springboot.model.entity.Book;
import com.learning.springboot.model.repository.BookRepository;
import com.learning.springboot.service.BookService;
import com.learning.springboot.util.LibraryUtil;
import java.util.ArrayList;
import java.util.List;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by krvh271 on 8/10/17.
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    @Qualifier("bookBatchJob")
    Job bookBatchJob;

    @Autowired
    ArrayList<Book> bookList;

    @Autowired
    BookRepository bookRepository;

    @Override
    public String addBook(Book book) {
        bookRepository.save(book);
        return LibraryUtil.SAVED;
    }

    @Override
    public String editBook(Book book) {
        bookRepository.save(book);
        return LibraryUtil.MODIFIED;
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(Long id) {
        return bookRepository.findOne(id);
    }

    @Override
    public String addBooks(ArrayList<Book> books) throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
//        System.out.println(System.currentTimeMillis());
//        bookRepository.save(books);
//        System.out.println(System.currentTimeMillis());

        bookList=books;
        JobParametersBuilder jobParameterBuilder = new JobParametersBuilder();
        JobExecution jobExecution = jobLauncher.run(bookBatchJob, jobParameterBuilder.toJobParameters());
        return LibraryUtil.SAVED;
    }

    @Override
    public String deleteBook(Long id) {
        bookRepository.delete(id);
        return LibraryUtil.DELETED;
    }
}
