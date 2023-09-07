package com.book.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Borrow {
    private int borrow_id;
    private int book_id;
    private String book_name;
    private Date time;
    private String student_name;
    private String student_id;
}
