package com.samson.LibraryAutomation.services;

import com.samson.LibraryAutomation.models.Book;
import com.samson.LibraryAutomation.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepo bookRepo;

    @Autowired
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getBooks(){
        return bookRepo.findAll();
    }

    public void addNewBook(String name, String author){

        Book book = new Book(name, author);
        bookRepo.save(book);
    }
}
