package cz.macecek.demo.demo.repository;

import cz.macecek.demo.demo.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class JsonBookRepositoryTest {

    JsonBookRepository jsonBookRepository = new JsonBookRepository("db-test.json");

    @BeforeEach
    public void setup() {
        jsonBookRepository.removeAll();
    }

    @Test
    public void saveTest() {
        Book book = new Book("LOTR", 2011, "Fantasy");
        jsonBookRepository.save(book);
        Assert.isTrue(jsonBookRepository.findAll().size() == 1, "Some book is saved");
        Assert.isTrue(jsonBookRepository.findAll().contains(book), "Book is saved");
    }

    @Test
    public void removeAllTest() {
        jsonBookRepository.save(new Book("LOTR", 2011, "Fantasy"));
        jsonBookRepository.save(new Book("LOTR2", 2011, "Fantasy"));
        Assert.isTrue(jsonBookRepository.findAll().size() == 2, "Two books are saved");
        jsonBookRepository.removeAll();
        Assert.isTrue(jsonBookRepository.findAll().size() == 0, "Two books are saved");
    }

    @Test
    void remove() {
        var lotr1 = new Book("LOTR", 2011, "Fantasy");
        jsonBookRepository.save(lotr1);
        jsonBookRepository.save(new Book("LOTR2", 2011, "Fantasy"));
        jsonBookRepository.remove("LOTR2");
        Assert.isTrue(jsonBookRepository.findAll().size() == 1, "Two books are saved");
        Assert.isTrue(jsonBookRepository.findAll().contains(lotr1), "Book is saved");
    }
}
