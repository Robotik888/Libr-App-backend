package cz.macecek.demo.demo.controller;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import cz.macecek.demo.demo.model.Book;
import cz.macecek.demo.demo.model.Borrow;
import cz.macecek.demo.demo.servis.BookService;
import cz.macecek.demo.demo.servis.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class JobController {
    private final BookService bookService;

    public JobController(@Autowired BookService bookService) {
        this.bookService = bookService;
    }
    @PostMapping(value = "/add")
    public void addBook(@RequestBody Book book) {
        System.out.println("Add Book Call");
        System.out.println(book.toString());
        bookService.add(book);
    }
    //NOT WORKING PROPERLY !!!!!!!!!!!!!!!!!!!!!!
    @PostMapping(value = "/remove")
    public void removeBook(@RequestBody String name) {
        System.out.println(name + name);
        System.out.println("Remove Book Call");
        System.out.println(name);
        bookService.remove(name);
    }
    //NOT WORKING PROPERLY !!!!!!!!!!!!!!!!!!!!!!

    @GetMapping(value = "/list")
    public List<Book> getAllBooks() {
        System.out.println("Get All Books call");
        return bookService.getAll();
    }
}








