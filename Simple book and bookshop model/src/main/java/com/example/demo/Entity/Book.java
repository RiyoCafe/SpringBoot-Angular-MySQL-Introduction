package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
@Data
@Entity
@Getter
@Setter
@ToString
@Table(name = "book")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //to generate id automatically.

    private Long book_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "bookshopNum")
    private BookShop bookshop;

    private String title;
    private Double price;
    private int publishYear;
    private String author;
    private String genre;
    private String publisher;

}
