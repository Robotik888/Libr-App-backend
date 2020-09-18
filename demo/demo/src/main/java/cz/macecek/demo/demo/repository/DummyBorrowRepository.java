package cz.macecek.demo.demo.repository;

import cz.macecek.demo.demo.BorrowRepository;
import cz.macecek.demo.demo.model.Borrow;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DummyBorrowRepository implements BorrowRepository {
    private static List<Borrow> borrows = new ArrayList<>();
    public void save(Borrow borrow) {
        borrows.add(borrow);
    }
    @Override
    public List<Borrow> findAll() {
        return borrows;
    }
}
