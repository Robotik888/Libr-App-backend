package cz.macecek.demo.demo.servis;

import cz.macecek.demo.demo.BookRepository;
import cz.macecek.demo.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookService {


    private final BookRepository repository;

    public BookService(@Autowired @Qualifier(value = "jsonBookRepository") BookRepository repository) {
        this.repository = repository;
    }

    public void add(Book book) {
        book.setCreated(LocalDate.now());

        repository.save(book);
    }

    public List<Book> getAll() {
        return repository.findAll();
    }

    public void remove(String name) {
        repository.remove(name);
    }

    public List<String> getAllNames() {
        return repository.findAllNames();
    }
}
