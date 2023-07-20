package com.salihpolat.controller;

import com.salihpolat.repository.entity.Borrow;
import com.salihpolat.service.BorrowService;

public class BorrowController {

    private BorrowService borrowService;

    public BorrowController() {
        this.borrowService = new BorrowService();
    }

    public Borrow save(Borrow borrow) {
        return borrowService.save(borrow);
    }
}