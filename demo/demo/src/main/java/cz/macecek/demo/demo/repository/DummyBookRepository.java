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
        ArrayList<Book>  toRemove = new ArrayList<>();
        int index = 0;
        for (Book book: this.books) {
            if (book.getName().equals(name)) {
                toRemove.add(book);
           }
        }
        for (Book book: toRemove) {
            this.books.remove(book);
        }
    }

    public List<String> findAllNames() {
        List<String> booksNames = new ArrayList<>();
        for (Book book: this.books) {
            booksNames.add(book.getName());
        }
        return booksNames;
    }
}
