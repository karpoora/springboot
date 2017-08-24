package com.learning.springboot.batch;

import com.learning.springboot.model.entity.Book;
import java.util.ArrayList;
import java.util.List;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by krvh271 on 8/19/17.
 */
public class BookReader implements ItemReader<List<Book>> {
    @Autowired
    @Qualifier("getBooks")
    ArrayList<Book> bookList;

    @Override
    public ArrayList<Book> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return bookList;
    }
}
