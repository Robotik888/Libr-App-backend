package cz.macecek.demo.demo.model;

import java.time.LocalDate;

public class Book {
    private String name;
    private int year;
    private String genre;
    private LocalDate crated;

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
                '}';
    }
    public void setCrated(LocalDate created) {
        this.crated = created;
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

    public LocalDate getCrated() {
        return crated;
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
}
