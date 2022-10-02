package com.ubicaplus.service;

import com.ubicaplus.domain.Book;
import com.ubicaplus.payload.CIFIN;
import com.ubicaplus.payload.SoapRequest;

public interface BookService {
    public Book getBook(long id);

    public long addBook(Book book);

    public long getBookCount();

    public CIFIN getData(SoapRequest request);
}
