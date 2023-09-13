package com.book.entity;

import lombok.Data;

@Data
public class Book {
    private int bid;
    private String title;
    private String desc;
    private double price;
}
