package com.book.service;

import com.book.entity.Book;
import com.book.entity.Borrow;

import java.util.List;
import java.util.Map;

public interface BookService {

    List<Borrow> getBorrowList();
    Map<Book, Boolean> getBookList();
    void addBook(String title, String desc, double price);
    void deleteBook(int bid);

}
