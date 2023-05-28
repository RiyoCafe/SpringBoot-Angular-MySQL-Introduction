package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //to generate id automatically.
    private Long book_id;
    private String title;
    private Double price;
    private int publishYear;
    private String author;
    private String genre;
    private String publisher;
}
