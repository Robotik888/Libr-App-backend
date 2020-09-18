package cz.macecek.demo.demo.repository;

import cz.macecek.demo.demo.BookRepository;
import cz.macecek.demo.demo.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DummyBookRepository implements BookRepository {
    private static List<Book> books = new ArrayList<>();
    public void save(Book book) {
        books.add(book);
    }

    @Override
    public List<Book> findAll() {
        return books;
    }
    public void remove(String name) {
        for (Book book: this.books) {
            if (book.getName().equals(name)) {
                books.remove(book);
            }
        }
    }
}
