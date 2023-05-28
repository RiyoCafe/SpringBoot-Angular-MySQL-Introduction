package com.example.demo.Controller;

import com.example.demo.Entity.BookShop;
import com.example.demo.Repository.BookShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookShopController {
    @Autowired
    private BookShopRepository bookShopRepository;
    @PostMapping("/addBookShop")
    public ResponseEntity<BookShop> addBookShop(@RequestBody BookShop bookShop){
        BookShop newBookShop=bookShopRepository.save(bookShop);
        return new ResponseEntity<>(newBookShop, HttpStatus.CREATED);
    }

    @GetMapping("/bookshops")
    public ResponseEntity<List<BookShop>> getAllBooks(){
        return new ResponseEntity<>(bookShopRepository.findAll(),HttpStatus.OK);
    }

    @GetMapping("/bookshops/{id}")
    public BookShop getBookshopByid(@PathVariable int id){
        return bookShopRepository.findById(id).get();
    }
    @GetMapping("/bookshopName/{title}")
    public BookShop getBookshopByid(@PathVariable String title){
        return bookShopRepository.findByTitle(title);
    }

    @PutMapping("/bookshops/updateShop")
    public ResponseEntity <BookShop> updateBookShop(@RequestBody BookShop bookShop)
    {
        BookShop updatedBookShop=bookShopRepository.findById(bookShop.getShop_no()).orElse(null);
        updatedBookShop.setLocation(bookShop.getLocation());
        updatedBookShop.setEmail(bookShop.getEmail());
        updatedBookShop.setContact_no(bookShop.getContact_no());
        updatedBookShop.setTitle(bookShop.getTitle());
        updatedBookShop.setPublishYear(bookShop.getPublishYear());
        return new ResponseEntity<>(bookShopRepository.save(updatedBookShop),HttpStatus.OK);
    }
    @DeleteMapping("/bookshops/delete/{id}")
    public ResponseEntity<BookShop> deleteBook(@PathVariable int id)
    {
        BookShop deletedBookShop=bookShopRepository.findById(id).orElse(null);
        if(deletedBookShop==null)   return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        bookShopRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
