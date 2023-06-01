package com.example.demo.Service;

import com.example.demo.Entity.Book;
import com.example.demo.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public ResponseEntity<Book> addBook(Book book)
    {
        //System.out.printf(book.toString());
        Book savedBook=bookRepository.save(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    public ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity<>(bookRepository.findAll(),HttpStatus.OK);
    }
    public Book getbookByid(long id){
        return bookRepository.findById(id).get();
    }
    public Book getbookBytitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public ResponseEntity <Book> updateBook(Book book,long id)
    {
        Book updatedBook=bookRepository.findById(id).orElse(null);
        updatedBook.setGenre(book.getGenre());
        updatedBook.setTitle(book.getTitle());
        updatedBook.setPrice(book.getPrice());
        updatedBook.setPublishYear(book.getPublishYear());
        updatedBook.setPublisher(book.getPublisher());
        updatedBook.setAuthor(book.getAuthor());
        return new ResponseEntity<>(bookRepository.save(updatedBook),HttpStatus.OK);
    }
    public ResponseEntity<Book> deleteBook(@PathVariable long id)
    {
        Book deletedBook=bookRepository.findById(id).orElse(null);
        if(deletedBook==null)   return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        bookRepository.deleteById(id);
        return new ResponseEntity<>(deletedBook,HttpStatus.OK);
    }

    public ResponseEntity<List<Book>> deleteAllbooks() {
        bookRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
