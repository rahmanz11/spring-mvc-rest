package com.ubicaplus.controller;

import com.ubicaplus.domain.Book;
import com.ubicaplus.domain.ObjectWithId;
import com.ubicaplus.payload.CIFIN;
import com.ubicaplus.payload.SoapRequest;
import com.ubicaplus.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.inject.Named;


@RestController
@RequestMapping("/book")
public class BookRestController {

    private BookService bookService;

    private Logger logger = LoggerFactory.getLogger(BookRestController.class);


    //Note: The @Named("bookService") is not required in this example (as there only instance of BookService around)
    @Inject
    public BookRestController(@Named("bookService") BookService bookService) {
        this.bookService = bookService;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Book getBook(@PathVariable("id") Long id) {
        logger.debug("Provider has received request to get person with id: " + id);
        return bookService.getBook(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ObjectWithId addBook(@RequestBody Book book) {
        return new ObjectWithId(bookService.addBook(book));
    }

    @RequestMapping(value = "/get-data", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public CIFIN submit(@RequestBody SoapRequest request) {
        return bookService.getData(request);
    }
}
