package com.example.demo.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bookshop")
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
    @JsonIgnore
    @OneToMany(mappedBy = "bookshop")
    private Set<Book> books=new HashSet<>();
}
