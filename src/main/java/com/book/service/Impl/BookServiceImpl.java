package com.book.service.Impl;

import com.book.entity.Book;
import com.book.entity.Borrow;
import com.book.mapper.BookMapper;
import com.book.service.BookService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    BookMapper bookMapper;

    @Override
    public List<Borrow> getBorrowList() {
        return bookMapper.getBorrowList();
    }

    @Override
    public Map<Book, Boolean> getBookList() {
        Set<Integer> set = new HashSet<>();
        this.getBorrowList().forEach(borrow -> set.add(borrow.getBid()));
        Map<Book, Boolean> map = new LinkedHashMap<>();
        bookMapper.getBookList().forEach(book -> map.put(book, set.contains(book.getBid())));
        return map;
    }

    @Override
    public void addBook(String title, String desc, double price) {
        bookMapper.addBook(title, desc, price);
    }

    @Override
    public void deleteBook(int bid) {
        bookMapper.deleteBook(bid);
    }
}
