package com.example.test_spring.service;

import com.example.test_spring.entity.Transaction;
import com.example.test_spring.entity.Transactions;
import com.example.test_spring.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TransactionService implements ITransactionService{

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Transactions findAll() {

        var transactions = (List<Transaction>) transactionRepository.findAll();
        var myTransactions = new Transactions();
        myTransactions.setTransactions(transactions);

        return myTransactions;
    }

    @Override
    public Transaction findById(Long id) {

        return transactionRepository.findById(id).orElse(new Transaction());
    }

    @Override
    public void save(Transactions transactions) {

        transactionRepository.saveAll(transactions.getTransaction());
    }
}
