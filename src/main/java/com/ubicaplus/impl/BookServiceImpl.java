package com.ubicaplus.impl;

import com.ubicaplus.domain.Book;
import com.ubicaplus.payload.CIFIN;
import com.ubicaplus.payload.SoapRequest;
import com.ubicaplus.payload.SoapResponse;
import com.ubicaplus.service.BookService;
import com.ubicaplus.service.SoapClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
@PropertySource("classpath:application.properties")
@Named("bookService")
public class BookServiceImpl implements BookService {

    private static Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    // In-memory list
    private List<Book> books = new ArrayList<>();
    private SoapClient soapClient = new SoapClient();

    @Value(value = "${auth.username}")
    private String userName;

    @Value(value = "${auth.password}")
    private String password;

    public BookServiceImpl() {
        init();
    }

    private void init() {
        addBook("John Smith", "Spring Framework intro");
        addBook("William Smith", "Advanced Java");
    }

    public Book getBook(long id) {
        logger.info("Retrieving id {}", id);
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public long addBook(Book book) {
        int idTodSet = atomicInteger.getAndIncrement();
        book.setId(idTodSet);
        books.add(book);
        return idTodSet;
    }

    public long addBook(String author, String title) {
        Book book = new Book(-1, author, title);
        return addBook(book);
    }

    public long getBookCount() {
        return books.size();
    }

    @Override
    public CIFIN getData(SoapRequest request) {
        SoapResponse response = soapClient.call(request, userName, password);
        return response.getCIFIN();
    }
}


