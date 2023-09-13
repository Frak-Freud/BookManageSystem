package com.book.mapper;

import com.book.entity.Borrow;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

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
}
