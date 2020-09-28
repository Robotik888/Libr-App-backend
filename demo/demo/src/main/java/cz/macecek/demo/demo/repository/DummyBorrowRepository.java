package cz.macecek.demo.demo.repository;

import cz.macecek.demo.demo.BorrowRepository;
import cz.macecek.demo.demo.model.Book;
import cz.macecek.demo.demo.model.Borrow;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DummyBorrowRepository implements BorrowRepository {
    private static List<Borrow> borrows = new ArrayList<>();
    public void save(Borrow borrow) {
        borrows.add(borrow);
    }
    public void remove(String title) {
        ArrayList<Borrow>  toRemove = new ArrayList<>();
        int index = 0;
        for (Borrow borrow: this.borrows) {
            if (borrow.getTitle().equals(title)) {
                toRemove.add(borrow);
            }
        }
        for (Borrow borrow: toRemove) {
            this.borrows.remove(borrow);
        }
    }
    @Override
    public List<Borrow> findAll() {
        return borrows;
    }

    public List<Borrow> findAllDelayed() {
        LocalDate now = LocalDate.now();
        List<Borrow> delayed = new ArrayList<Borrow>();
        for (Borrow borrow: borrows) {
            LocalDate borrowDate = LocalDate.parse(borrow.getReturnDate());
            if (now.isAfter(borrowDate)) {
                delayed.add(borrow);
            }
        }
        return delayed;
    }

    public List<String> findAllNames() {
        List<String> borrowsNames = new ArrayList<>();
        for (Borrow borrow: this.borrows) {
            borrowsNames.add(borrow.getTitle());
        }
        return borrowsNames;
    }
}
