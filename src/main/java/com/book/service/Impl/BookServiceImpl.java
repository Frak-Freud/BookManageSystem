package com.book.service.Impl;

import com.book.entity.Borrow;
import com.book.mapper.BookMapper;
import com.book.service.BookService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    BookMapper bookMapper;

    @Override
    public List<Borrow> getBorrowList() {
        return bookMapper.getBorrowList();
    }
}
