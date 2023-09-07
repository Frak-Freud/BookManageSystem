package com.book.servlet.pages;

import com.book.entity.Book;
import com.book.entity.Borrow;
import com.book.entity.User;
import com.book.service.BookService;
import com.book.service.Impl.BookServiceImpl;
import com.book.service.Impl.StudentServiceImpl;
import com.book.service.StudentService;
import com.book.utils.ThymeleafUtil;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.Context;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {

    BookService bookService;
    StudentService studentService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        bookService = new BookServiceImpl();
        studentService = new StudentServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        User user = (User) req.getSession().getAttribute("user");
        context.setVariable("nickname", user.getNickname());
        // 借阅管理
        List<Borrow> borrowList = bookService.getBorrowList();
        context.setVariable("borrow_count", borrowList.size());
        context.setVariable("borrow_list", borrowList);
        // 其它数据
        Map<Book, Boolean> bookList = bookService.getBookList();
        context.setVariable("book_count", bookList.size());
        context.setVariable("student_count", studentService.getStudentList().size());
        context.setVariable("rest_count", bookList.size() - borrowList.size());

        ThymeleafUtil.process("index.html", context, resp.getWriter());
    }


}
