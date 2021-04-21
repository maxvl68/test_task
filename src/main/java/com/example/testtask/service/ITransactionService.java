package com.example.testtask.service;

import com.example.testtask.entity.Transaction;
import com.example.testtask.entity.Transactions;

public interface ITransactionService {

    Transactions findAll();

    Transaction findById(Long id);

    void save(Transactions transactions);
}