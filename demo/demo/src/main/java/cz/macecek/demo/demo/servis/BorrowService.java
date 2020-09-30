package cz.macecek.demo.demo.servis;

import cz.macecek.demo.demo.BorrowRepository;
import cz.macecek.demo.demo.model.Book;
import cz.macecek.demo.demo.model.Borrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BorrowService {
    private final BorrowRepository repository;
    public BorrowService(@Autowired BorrowRepository repository) {
        this.repository = repository;
    }


    public void add(Borrow borrow) {
        borrow.setCreated(LocalDate.now());

        repository.save(borrow);
    }
    public void remove(String title) {
        repository.remove(title);
    }

    public List<Borrow> getAll(){
        return repository.findAll();
    }

    public List<Borrow> getAllDelayed(){
        return repository.findAllDelayed();
    }

    public List<String> getAllNames() {
        return repository.findAllNames();
    }
    }

