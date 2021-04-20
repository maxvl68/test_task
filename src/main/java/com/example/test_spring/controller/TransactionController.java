package com.example.test_spring.controller;

import com.example.test_spring.entity.Transaction;
import com.example.test_spring.entity.Transactions;
import com.example.test_spring.service.ITransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    private ITransactionService transactionService;

    @GetMapping(value="/transactions", produces=MediaType.APPLICATION_XML_VALUE)
    public Transactions findTransactions() {

        return transactionService.findAll();
    }

    @GetMapping(value="/transactions/{cityId}", produces=MediaType.APPLICATION_XML_VALUE)
    public Transaction findTransaction(@PathVariable Long cityId) {

        return transactionService.findById(cityId);
    }
}
