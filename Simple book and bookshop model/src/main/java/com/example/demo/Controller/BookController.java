package com.example.demo.Controller;
import com.example.demo.Entity.Book;
import com.example.demo.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired  //Repository auto initialize
    private BookRepository bookRepository;
    @GetMapping("/hello")
    public String hello(){
        return "Hello world";
    }

    @GetMapping("/books/{title}")
    public Book getbookBytitle(@PathVariable String title) {
        return bookRepository.findByTitle(title);
    }

    @PostMapping("/books/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) //for json objects
    {
        //System.out.printf(book.toString());
        Book savedBook=bookRepository.save(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }
    @GetMapping("/books")
    public ResponseEntity<List<Book> > getAllBooks(){
        return new ResponseEntity<>(bookRepository.findAll(),HttpStatus.OK);
    }
    @GetMapping("/booka/{id}")
    public Book getbookByid(@PathVariable long id){
        return bookRepository.findById(id).get();
    }
    @PutMapping("/books/update")
    public ResponseEntity <Book> updateBook(@RequestBody Book book)
    {
        Book updatedBook=bookRepository.findById(book.getBook_id()).orElse(null);
        updatedBook.setGenre(book.getGenre());
        updatedBook.setTitle(book.getTitle());
        updatedBook.setPrice(book.getPrice());
        updatedBook.setPublishYear(book.getPublishYear());
        updatedBook.setPublisher(book.getPublisher());
        updatedBook.setAuthor(book.getAuthor());
        return new ResponseEntity<>(bookRepository.save(updatedBook),HttpStatus.OK);
    }
    @DeleteMapping("/books/delete/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable long id)
    {
        Book deletedBook=bookRepository.findById(id).orElse(null);
        if(deletedBook==null)   return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        bookRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
