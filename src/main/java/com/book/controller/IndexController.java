package com.book.controller;

import com.book.entity.Borrow;
import com.book.service.BookService;
import com.book.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    // @Resource
    // UserService userService;

    @Resource
    BookService bookService;

    @GetMapping({"/", "index"})
    public String index(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("nickname", user.getUsername());
        List<Borrow> borrowList = bookService.getBorrowList();
        model.addAttribute("borrow_list", borrowList);


        return "index";
    }


}
