package com.example.test_spring.entity;

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
@Table(name = "clients")
@JacksonXmlRootElement(localName = "Client")
public class Client implements Serializable {
    private static final long serialVersionUID = 21L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JacksonXmlProperty(isAttribute = true)
    private Long id;

    @JacksonXmlProperty
    private String firstName;

    @JacksonXmlProperty
    private String lastName;

    @JacksonXmlProperty
    private String middleName;

    @JacksonXmlProperty
    private String inn;
}
