package cz.macecek.demo.demo;

import cz.macecek.demo.demo.model.Book;

import java.util.List;

public interface BookRepository {
    void save(Book book);

    List<Book> findAll();

    void remove(String name);

    List<String> findAllNames();

    void removeAll();
}
