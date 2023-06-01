package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@Table(name = "book")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //to generate id automatically.

    private Long book_id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name= "shopId",referencedColumnName = "shop_no")
    private BookShop bookShop;

    private String title;
    private Double price;
    private int publishYear;
    private String author;
    private String genre;
    private String publisher;

}
