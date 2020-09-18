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
    @PostMapping(value = "/remove")
    public void removeBook(@RequestBody String name) {
        System.out.println("Remove Book Call (for book: " + name + ")");
        bookService.remove(name);
    }

    @GetMapping(value = "/list")
    public List<Book> getAllBooks() {
        System.out.println("Get All Books call");
        return bookService.getAll();
    }

    @GetMapping(value = "/list/names")
    public List<String> getAllBookNames() {
        System.out.println("Get All Book Names Call");
        return bookService.getAllNames();
    }
}








