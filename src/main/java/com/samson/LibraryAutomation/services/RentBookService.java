package com.samson.LibraryAutomation.services;

import com.samson.LibraryAutomation.models.Book;
import com.samson.LibraryAutomation.models.RentBook;
import com.samson.LibraryAutomation.repo.BookRepo;
import com.samson.LibraryAutomation.repo.ReaderRepo;
import com.samson.LibraryAutomation.repo.RentBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentBookService {

    private final RentBookRepo rentBookRepo;
    private final BookRepo bookRepo;
    private final ReaderRepo readerRepo;

    @Autowired
    public RentBookService(RentBookRepo rentBookRepo, BookRepo bookRepo, ReaderRepo readerRepo) {
        this.rentBookRepo = rentBookRepo;
        this.bookRepo = bookRepo;
        this.readerRepo = readerRepo;
    }


    public void rentBook(int readerID, int bookID) {

        Book book = bookRepo.findById(bookID).get();
        book.setStatus(false);
        bookRepo.save(book);

        RentBook rentBook = new RentBook(bookRepo.findById(bookID).get(), readerRepo.findById(readerID).get());
        rentBookRepo.save(rentBook);
    }
}
