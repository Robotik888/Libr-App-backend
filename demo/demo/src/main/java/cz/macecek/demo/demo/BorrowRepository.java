package cz.macecek.demo.demo;

import cz.macecek.demo.demo.model.Borrow;

import java.util.List;

public interface BorrowRepository {
    void save(Borrow borrow);
    List<Borrow> findAll();
}
