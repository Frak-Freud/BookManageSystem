package com.book.mapper;

import com.book.entity.Account;
import com.book.entity.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * from user where username = #{username}")
    Account getUserByName(String username);

    @Select("select * from student")
    List<Student> getStudentList();

}
