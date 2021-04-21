package com.example.testtask.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@ToString

@Entity
@Table(name = "transactions")
@JacksonXmlRootElement(localName = "Transaction")
public class Transaction implements Serializable {
    private static final long serialVersionUID = 22L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JacksonXmlProperty(isAttribute = true)
    private Long id;

    @JacksonXmlProperty
    private String place;

    // toDo joda-money or BigDecimal
    @JacksonXmlProperty
    private String amount;

    @JacksonXmlProperty
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @JacksonXmlProperty
    private String card;

    @OneToOne
    @JoinColumn(name = "id_client")
    @JacksonXmlProperty
    private Client client;
}
