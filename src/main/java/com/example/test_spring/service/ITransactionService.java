package com.example.test_spring.service;

import com.example.test_spring.entity.Transaction;
import com.example.test_spring.entity.Transactions;

public interface ITransactionService {

    Transactions findAll();

    Transaction findById(Long id);

    void save(Transactions transactions);
}