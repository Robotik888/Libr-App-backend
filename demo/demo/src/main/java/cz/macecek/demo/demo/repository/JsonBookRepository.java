package cz.macecek.demo.demo.repository;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import cz.macecek.demo.demo.BookRepository;
import cz.macecek.demo.demo.model.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JsonBookRepository implements BookRepository {


    private String dbFileName;

    public JsonBookRepository(@Value("${db.name}") String dbFileName) {
        this.dbFileName = dbFileName;
    }

    private Gson gson = new Gson();

    public void save(Book book) {
        List<Book> all = findAll();
        all.add(book);
        saveAll(all);
    }

    private void saveAll(List<Book> books) {
        try (PrintWriter out = new PrintWriter(dbFileName)) {
            out.println(gson.toJson(books));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Book> findAll() {
        try {
            String json = Files.readString(Path.of(dbFileName));
            List<Book> books = gson.fromJson(
                    json, new TypeToken<List<Book>>() {
                    }.getType()
            );
            return books != null ? books : new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }


    public void remove(String name) {
        saveAll(
                findAll()
                        .stream()
                        .filter(book -> !book.getName().equals(name))
                        .collect(Collectors.toList())
        );
    }

    public List<String> findAllNames() {
        return findAll().stream().map(Book::getName).collect(Collectors.toList());
    }

    @Override
    public void removeAll() {
        saveAll(Collections.emptyList());
    }
}
