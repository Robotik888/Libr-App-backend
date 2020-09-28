package cz.macecek.demo.demo.repository;

import cz.macecek.demo.demo.BookRepository;
import cz.macecek.demo.demo.database.BookDatabaseOne;
import cz.macecek.demo.demo.model.Book;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LessDummyBookRepository {
    private BookDatabaseOne database = new BookDatabaseOne();
    private List<Book> books;


    public void save(Book book) {
        database.writeLine(book);

    }

    //@Override
    public List<Book> findAll() {
        return database.ReadLines();
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
