package com.example.demo.Controller;
import com.example.demo.Entity.Book;

import com.example.demo.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired  // auto initialize
    private BookService bookService;

//    @GetMapping("/hello")
//    public String hello(){
//        return "Hello world";
//    }

    @GetMapping("/api/books/{title}")
    public Book getbookBytitle(@PathVariable String title) {
        return bookService.getbookBytitle(title);
    }

    @PostMapping("/api/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) //for json objects
    {
        //System.out.printf(book.toString());
        return bookService.addBook(book);
    }
    @GetMapping("/api/books")
    public ResponseEntity<List<Book> > getAllBooks(){
        return bookService.getAllBooks();
    }
    @GetMapping("/api/books/{id}")
    public Book getbookByid(@PathVariable long id){
        return bookService.getbookByid(id);
    }
    @PutMapping("/api/books/{id}")
    public ResponseEntity <Book> updateBook(@RequestBody Book book,@PathVariable long id)
    {
        return bookService.updateBook(book,id);
    }
    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable long id)
    {
        return bookService.deleteBook(id);

    }
    @DeleteMapping("/api/books")
    public ResponseEntity<List<Book> > deleteAllbooks()
    {
        return bookService.deleteAllbooks();
    }

}
