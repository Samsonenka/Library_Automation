package com.samson.LibraryAutomation.services;

import com.samson.LibraryAutomation.models.Book;
import com.samson.LibraryAutomation.models.Reader;
import com.samson.LibraryAutomation.models.RentBook;
import com.samson.LibraryAutomation.repo.BookRepo;
import com.samson.LibraryAutomation.repo.RentBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final BookRepo bookRepo;
    private final RentBookRepo rentBookRepo;

    @Autowired
    public BookService(BookRepo bookRepo, RentBookRepo rentBookRepo) {
        this.bookRepo = bookRepo;
        this.rentBookRepo = rentBookRepo;
    }

    public List<Book> getBooks(){
        return bookRepo.findAll();
    }

    public List<Book> getBooks(Reader reader){

        List<RentBook> rentBookList = rentBookRepo.findAll();
        List<Book> bookList = new ArrayList<>();

        for (RentBook value: rentBookList) {
            if (value.getReader().getId() == reader.getId()){
                bookList.add(value.getBook());
            }
        }

        return bookList;
    }


    public void addNewBook(String name, String author){

        Book book = new Book(name, author);
        bookRepo.save(book);
    }

    public void deleteBook(int id) {
        bookRepo.delete(bookRepo.findById(id).get());
    }

    public List<Book> findBookByNameOrAuthor(String name, String filter) {

        List<Book> booksList = new ArrayList<>();

        switch (filter){

            case "book":
                booksList = findByBook(name);
                break;
            case "author":
                booksList = findByAuthor(name);
                break;
        }
        return booksList;
    }

    public List<Book> findByBook(String book) {

        List<Book> booksList = new ArrayList<>();

        for (Book value: getBooks()) {
            if (value.getName().equals(book)){
                booksList.add(value);
            }
        }
        return booksList;
    }

    public List<Book> findByAuthor(String author){

        List<Book> booksList = new ArrayList<>();

        for (Book value: getBooks()) {
            if (value.getAuthor().equals(author)){
                booksList.add(value);
            }
        }
        return booksList;
    }

    public Object getBookById(int id) {
        return bookRepo.findById(id).get();
    }
}
