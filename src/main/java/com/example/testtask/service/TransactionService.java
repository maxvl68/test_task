package com.example.testtask.service;

import com.example.testtask.entity.Transaction;
import com.example.testtask.entity.Transactions;
import com.example.testtask.repository.TransactionRepository;
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
