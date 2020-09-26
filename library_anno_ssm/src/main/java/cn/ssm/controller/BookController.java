package cn.ssm.controller;

import cn.ssm.domain.Books;
import cn.ssm.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/addBooks")
    public String addBooks(Books books) {
        bookService.addBooks(books);
        return "redirect:/book/findAllBooks";
    }

    @RequestMapping("/toAddBook")
    public String toAddBooks() {
        return "addBook";
    }

    @RequestMapping("/deleteBooks/{bookId}")
    public String deleteBooks(@PathVariable("bookId") int id) {
        bookService.deleteBooks(id);
        return "redirect:/book/findAllBooks";
    }

    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(int id, Model model) {
        Books books = bookService.findBooksById(id);
        System.out.println(books);
        model.addAttribute("book", books);
        return "updateBook";
    }

    @RequestMapping("/updateBooks")
    public String updateBooks(Books books, Model model) {
        bookService.updateBooks(books);
        Books book = bookService.findBooksById(books.getBookID());
        model.addAttribute("book", "book");
        return "redirect:/book/findAllBooks";

    }

    @RequestMapping("/findAllBooks")
    public String findAllBooks(Model model) {
        System.out.println("Controller:findAllBooks()");
        List<Books> list = bookService.findAllBooks();
        model.addAttribute("list", list);
        return "allbooks";
    }

    @RequestMapping("/findBooksByName")
    public String findBooksByName(String bookName, Model model) {
        Books books = bookService.findBookByName(bookName);
        System.err.println("books=>" + books);
        List<Books> list = new ArrayList<Books>();
        list.add(books);
        if (books == null) {
            list = bookService.findAllBooks();
            model.addAttribute("error", "未查到!");
        }
        model.addAttribute("list", list);
        return "allbooks";

    }

}
