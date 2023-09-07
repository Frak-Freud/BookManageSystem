package com.book.service;

import com.book.entity.Book;
import com.book.entity.Borrow;

import java.util.List;
import java.util.Map;

public interface BookService {
    List<Borrow> getBorrowList();
    List<Book> getActiveBookList();
    Map<Book, Boolean> getBookList();
    void returnBook(int id);

}
