package com.example.demo.Service;

import com.example.demo.Entity.Book;
import com.example.demo.Entity.BookShop;
import com.example.demo.Repository.BookRepository;
import com.example.demo.Repository.BookShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class BookShopService {
    @Autowired
    private BookShopRepository bookShopRepository;
    @Autowired
    BookRepository bookRepository;
    public ResponseEntity<BookShop> addBookShop( BookShop bookShop){
        BookShop newBookShop=bookShopRepository.save(bookShop);
        return new ResponseEntity<>(newBookShop, HttpStatus.CREATED);
    }

    public ResponseEntity<List<BookShop>> getAllBooks(){
        return new ResponseEntity<>(bookShopRepository.findAll(),HttpStatus.OK);
    }

    public BookShop getBookshopByid(int id){
        return bookShopRepository.findById(id).get();
    }


    public BookShop getBookshopBytitle( String title){
        return bookShopRepository.findByTitle(title);
    }

    public ResponseEntity <BookShop> updateBookShop(BookShop bookShop,int id)
    {
        BookShop updatedBookShop=bookShopRepository.findById(id).orElse(null);
        updatedBookShop.setLocation(bookShop.getLocation());
        updatedBookShop.setEmail(bookShop.getEmail());
        updatedBookShop.setContact_no(bookShop.getContact_no());
        updatedBookShop.setTitle(bookShop.getTitle());
        updatedBookShop.setPublishYear(bookShop.getPublishYear());
        return new ResponseEntity<>(bookShopRepository.save(updatedBookShop),HttpStatus.OK);
    }

    public ResponseEntity<BookShop> deleteBook( int id)
    {
        BookShop deletedBookShop=bookShopRepository.findById(id).orElse(null);
        if(deletedBookShop==null)   return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        bookShopRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<BookShop> assignAll(long bookId, int shopId) {
        Book book=bookRepository.findById(bookId).get();
        System.out.println(book);
        BookShop bookShop=bookShopRepository.findById(shopId).get();
        System.out.println(bookShop);
        //bookShop.getBooks().add(book);
        book.setBookshop(bookShop);
        Book savedbook=bookRepository.save(book);
        System.out.println(savedbook);
        return new ResponseEntity<>(bookShop,HttpStatus.OK);
    }
}
