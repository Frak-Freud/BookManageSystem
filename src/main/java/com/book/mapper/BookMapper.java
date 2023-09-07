package com.book.mapper;

import com.book.entity.Book;
import com.book.entity.Borrow;
import org.apache.ibatis.annotations.*;

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

    @Delete("delete from borrow where id = #{id}")
    void deleteBorrow(int id);

    @Insert("insert into borrow(sid, bid, time) values(#{sid}, #{bid}, NOW())")
    void addBorrow(@Param("sid") int sid, @Param("bid") int bid);

    // 注意关键字desc转义
    @Insert("insert into book(title, `desc`, price) values(#{title}, #{desc}, #{price})")
    void addBook(@Param("title") String title, @Param("desc") String desc, @Param("price") double price);


}
