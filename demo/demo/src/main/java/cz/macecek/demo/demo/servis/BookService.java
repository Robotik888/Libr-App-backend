package cz.macecek.demo.demo.servis;

import cz.macecek.demo.demo.BookRepository;
import cz.macecek.demo.demo.model.Book;
import cz.macecek.demo.demo.repository.DummyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(@Autowired BookRepository repository) {
        this.repository = repository;
    }

    public void add(Book book) {


        book.setCrated(LocalDate.now());

        repository.save(book);
    }

    public List<Book> getAll() {
        return repository.findAll();
    }

    public void remove(String name) {
        repository.remove(name);
    }
}
