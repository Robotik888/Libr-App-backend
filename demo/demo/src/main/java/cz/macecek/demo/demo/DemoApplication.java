package cz.macecek.demo.demo;

import cz.macecek.demo.demo.model.Book;
import cz.macecek.demo.demo.servis.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DemoApplication {
    private final BookService bookService;

    public DemoApplication(BookService bookService) {
        this.bookService = bookService;
    }


    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);

    }

    @PostConstruct
    public void init() {
        for (Book book : bookService.getAll()) {
            System.out.println(book);
        }
    }
}
