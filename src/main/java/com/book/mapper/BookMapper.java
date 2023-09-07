package com.book.mapper;

import com.book.entity.Book;
import com.book.entity.Borrow;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookMapper {


    @Results({
            @Result(column = "id", property = "borrow_id"),
            @Result(column = "bid", property = "book_id"),
            @Result(column = "title", property = "book_name"),
            @Result(column = "time", property = "time"),
            @Result(column = "name", property = "student_name"),
            @Result(column = "sid", property = "student_id")
    })
    @Select("select * from borrow, student, book where borrow.sid = student.sid and borrow.bid = book.bid")
    List<Borrow> getBorrowList();

    @Select("select * from book")
    List<Book> getBookList();


}
