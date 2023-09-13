package com.book.controller;

import com.book.entity.Book;
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
import java.util.Set;

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
        model.addAttribute("borrow_count", borrowList.size());
        Set<Book> bookList = bookService.getBookList().keySet();
        model.addAttribute("book_count", bookList.size());
        model.addAttribute("rest_count", bookList.size() - borrowList.size());

        return "index";
    }


}
