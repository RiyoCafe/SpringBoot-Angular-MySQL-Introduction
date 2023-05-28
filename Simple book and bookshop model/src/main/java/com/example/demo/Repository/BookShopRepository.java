package com.example.demo.Repository;

import com.example.demo.Entity.BookShop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookShopRepository extends JpaRepository<BookShop,Integer> {
    BookShop findByTitle(String title);
}
