package com.book.entity;

import lombok.Data;

@Data
public class Account {
    private int sid;
    private String username;
    private String password;
    private String role;

}
