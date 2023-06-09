package com.example.demo.Controller;

import com.example.demo.Entity.BookShop;
import com.example.demo.Service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class BookShopController {
    @Autowired
    private BookShopService bookShopService;


    @PostMapping("/api/bookshop")
    public ResponseEntity<BookShop> addBookShop(@RequestBody BookShop bookShop){
        return bookShopService.addBookShop(bookShop);
    }

    @GetMapping("/api/bookshop")
    public ResponseEntity<List<BookShop>> getAllBooks(){
        return bookShopService.getAllBooks();
    }

    @GetMapping("/api/bookshop/{id}")
    public BookShop getBookshopByid(@PathVariable int id){

        return bookShopService.getBookshopByid(id);
    }
    @GetMapping("/api/bookshop/{title}")
    public BookShop getBookshopBytitle(@PathVariable String title){
        return bookShopService.getBookshopBytitle(title);
    }

    @PutMapping("/api/bookshop/{id}")
    public ResponseEntity <BookShop> updateBookShop(@RequestBody BookShop bookShop,@PathVariable int id)
    {
        return bookShopService.updateBookShop(bookShop,id);
    }
    @DeleteMapping("/api/bookshop/{id}")
    public ResponseEntity<BookShop> deleteBook(@PathVariable int id)
    {
        return bookShopService.deleteBook(id);
    }

    @PutMapping("/bookshop/{shop_id}/books/{book_id}")
    public ResponseEntity<BookShop>  assignBookandBookshop(@PathVariable long book_id,@PathVariable int shop_id){
        return bookShopService.assignAll(book_id,shop_id);
    }


}
