package cz.macecek.demo.demo.model;
import java.time.LocalDate;
public class Borrow {

    private String title;
    private String name;
    private String returnDate;
    private String assumedReturnDate;
    private LocalDate created;

    public Borrow(String title, String name, String returnDate, String assumedReturnDate) {
        this.title = title;
        this.name = name;
        this.returnDate = returnDate;
        this.assumedReturnDate = assumedReturnDate;
    }
    public Borrow() {

    }

    @Override
    public String toString() {
        return "Borrow{" +
                "title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", returnDate=" + returnDate +
                ", assumedReturnDate=" + assumedReturnDate +
                '}';
    }
    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public String getAssumedReturnDate() {
        return assumedReturnDate;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public void setAssumedReturnDate(String assumedReturnDate) {
        this.assumedReturnDate = assumedReturnDate;
    }
}
