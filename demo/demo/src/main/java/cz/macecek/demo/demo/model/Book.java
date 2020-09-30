package cz.macecek.demo.demo.model;

import java.time.LocalDate;
import java.util.Objects;

public class Book {

    private String name;
    private int year;
    private String genre;
    private LocalDate created;

    public Book(String name, int year, String genre) {
        this.name = name;
        this.year = year;
        this.genre = genre;
    }
    public Book() {

    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", created=" + created +
                '}';
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year &&
                Objects.equals(name, book.name) &&
                Objects.equals(genre, book.genre) &&
                Objects.equals(created, book.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, genre, created);
    }
}
