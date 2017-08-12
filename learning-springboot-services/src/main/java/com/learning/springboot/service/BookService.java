package com.learning.springboot.service;

import com.learning.springboot.model.entity.Book;
import java.util.List;

/**
 * Created by krvh271 on 8/10/17.
 */
public interface BookService {
    String addBook(Book book);
    String editBook(Book book);
    List<Book> getBooks();
    Book getBook(Long id);
    String addBooks(List<Book> books);
    String deleteBook(Long id);
}
