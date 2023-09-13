package com.book.mapper;

import com.book.entity.Account;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from user where username = #{username}")
    Account getUserByName(String username);

}
