package com.example.demo.Controller;

import com.example.demo.Entity.BookShop;
import com.example.demo.Service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookShopController {
    @Autowired
    private BookShopService bookShopService;
    @PostMapping("/addBookShop")
    public ResponseEntity<BookShop> addBookShop(@RequestBody BookShop bookShop){
        return bookShopService.addBookShop(bookShop);
    }

    @GetMapping("/bookshops")
    public ResponseEntity<List<BookShop>> getAllBooks(){
        return bookShopService.getAllBooks();
    }

    @GetMapping("/bookshops/{id}")
    public BookShop getBookshopByid(@PathVariable int id){

        return bookShopService.getBookshopByid(id);
    }
    @GetMapping("/bookshopName/{title}")
    public BookShop getBookshopBytitle(@PathVariable String title){
        return bookShopService.getBookshopBytitle(title);
    }

    @PutMapping("/bookshops/updateShop")
    public ResponseEntity <BookShop> updateBookShop(@RequestBody BookShop bookShop)
    {
        return bookShopService.updateBookShop(bookShop);
    }
    @DeleteMapping("/bookshops/delete/{id}")
    public ResponseEntity<BookShop> deleteBook(@PathVariable int id)
    {
        return bookShopService.deleteBook(id);
    }

}
