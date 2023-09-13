package com.book.mapper;

import com.book.entity.Book;
import com.book.entity.Borrow;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookMapper {
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "sid", property = "sid"),
            @Result(column = "bid", property = "bid"),
            @Result(column = "name", property = "name"),
            @Result(column = "title", property = "title"),
            @Result(column = "time", property = "time")
    })
    @Select("""
            select * from borrow 
            left join student on borrow.sid = student.sid
            left join book on borrow.bid = book.bid
            """)
    List<Borrow> getBorrowList();

    @Select("select * from book")
    List<Book> getBookList();

    @Insert("insert into book(title, `desc`, price) values(#{title}, #{desc}, #{price})")
    void addBook(@Param("title") String title, @Param("desc") String desc, @Param("price") double price);

    @Delete("delete from book where bid = #{bid}")
    void deleteBook(int bid);

}
