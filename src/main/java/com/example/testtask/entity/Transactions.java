package com.example.testtask.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@JacksonXmlRootElement
public class Transactions implements Serializable {

    private static final long serialVersionUID = 23L;

    @JacksonXmlProperty(localName = "Transaction")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Transaction> transactions = new ArrayList<>();

    public List<Transaction> getTransaction() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
