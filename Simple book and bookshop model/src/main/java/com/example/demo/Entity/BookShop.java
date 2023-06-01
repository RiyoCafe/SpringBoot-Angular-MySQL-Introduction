package com.example.demo.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bookshopsagain")
public class BookShop implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shop_no;
    private long price;
    private int  publishYear;
    private String title;
    private String location;
    private String email;
    private String contact_no;
    @OneToMany(mappedBy = "bookShop")
    private Set<Book> books=new HashSet<>();
}
