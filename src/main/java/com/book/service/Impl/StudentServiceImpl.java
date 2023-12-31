package com.book.service.Impl;

import com.book.entity.Student;
import com.book.mapper.StudentMapper;
import com.book.service.StudentService;
import com.book.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> getStudentList() {
        try(SqlSession sqlSession = MybatisUtil.getSession()){
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            return mapper.getStudentList();
        }
    }
}
