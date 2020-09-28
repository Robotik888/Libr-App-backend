package cz.macecek.demo.demo.controller;

import cz.macecek.demo.demo.model.Borrow;
import cz.macecek.demo.demo.servis.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrow")
public class JobController2 {
    private final BorrowService borrowService;

    public JobController2(@Autowired BorrowService borrowService) {
        this.borrowService = borrowService;
    }
    @PostMapping(value = "/addBorrow")
    public void addBorrow(@RequestBody Borrow borrow) {
        System.out.println("Add Borrow Call");
        System.out.println(borrow.toString());
        borrowService.add(borrow);
    }

    @PostMapping(value = "/remove")
    public void removeBorrow(@RequestBody String title) {
        System.out.println("Remove Borrow Call (for book: " + title + ")");
        borrowService.remove(title);
    }

    @GetMapping(value = "/listBorrow")
    public List<Borrow> getAllBorrows() {
        System.out.println("Get All Borrows call");
        return borrowService.getAll();
    }

    @GetMapping(value = "/listDelayedBorrow")
    public List<Borrow> getAllDelayedBorrows() {
        System.out.println("Get All Delayed Borrows call");
        return borrowService.getAllDelayed();
    }
}
