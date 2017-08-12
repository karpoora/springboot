package com.learning.springboot.service.impl;

import com.learning.springboot.model.entity.Book;
import com.learning.springboot.model.repository.BookRepository;
import com.learning.springboot.service.BookService;
import com.learning.springboot.util.LibraryUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by krvh271 on 8/10/17.
 */
@Service
public class BookServiceImpl implements BookService {
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
    public String addBooks(List<Book> books) {
        bookRepository.save(books);
        return LibraryUtil.SAVED;
    }

    @Override
    public String deleteBook(Long id) {
        bookRepository.delete(id);
        return LibraryUtil.DELETED;
    }
}
