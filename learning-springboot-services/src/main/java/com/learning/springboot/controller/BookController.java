package com.learning.springboot.controller;

import com.learning.springboot.model.entity.Book;
import com.learning.springboot.model.handler.NoContentException;
import com.learning.springboot.service.BookService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by krvh271 on 8/10/17.
 */
@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping(path = "add-book")
    @PreAuthorize("hasAuthority('RAT-Admin')")
    public String addBook(@Valid @RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PostMapping(path = "add-books")
    @PreAuthorize("hasAuthority('RAT-Admin')")
    public String addBooks(@RequestBody ArrayList<Book> books) throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        return bookService.addBooks(books);
    }

    @PutMapping(path = "edit")
    @PreAuthorize("hasAuthority('RAT-Admin')")
    public String editBook(@RequestBody Book book) {
        return bookService.editBook(book);
    }

    @PatchMapping(path = "edit")
    @PreAuthorize("hasAuthority('RAT-Admin')")
    public String partialEditBook(@RequestBody Book book) {
        return bookService.editBook(book);
    }

    @GetMapping(path = "book/{id}")
    @PreAuthorize("hasAuthority('RAT-Admin')")
    public ResponseEntity<Resource<Book>> getBook(@PathVariable("id") Long id) {
        Book book=bookService.getBook(id);

//      Hateoas implementation
        Resource<Book> bookResource=new Resource<>(book);
        ControllerLinkBuilder linkBuilder=linkTo(methodOn(this.getClass()).getAllBooks());
        bookResource.add(linkBuilder.withRel("All-books"));

        if(book==null)
            throw new NoContentException("No Books found :"+id);
        return new ResponseEntity<Resource<Book>>(bookResource, HttpStatus.FOUND);
    }

    @GetMapping(path = "all-books")
    @PreAuthorize("hasAuthority('RAT-Admin')")
    public List<Book> getAllBooks() {
        return bookService.getBooks();
    }

    @DeleteMapping(path = "delete/{id}")
    @PreAuthorize("hasAuthority('RAT-Admin')")
    public String deleteBook(@PathVariable Long id) {
        return bookService.deleteBook(id);
    }
}


// PostMapping
// PutMapping
// GetMapping
// DeleteMapping
// PatchMapping
// Restcontroller
// RepositoryRestResource