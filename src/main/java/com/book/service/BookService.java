package com.book.service;

import com.book.entity.Book;
import com.book.entity.Borrow;

import java.util.List;
import java.util.Map;

public interface BookService {

    List<Borrow> getBorrowList();
    void addBorrow(int sid, int bid);
    void deleteBorrow(int id);
    Map<Book, Boolean> getBookList();
    List<Book> getActiveBookList();
    void addBook(String title, String desc, double price);
    void deleteBook(int bid);

}
