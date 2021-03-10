package com.samson.LibraryAutomation.controllers;

import com.samson.LibraryAutomation.services.BookService;
import com.samson.LibraryAutomation.services.ReaderService;
import com.samson.LibraryAutomation.services.RentBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RentBookController {

    private final BookService bookService;
    private final ReaderService readerService;
    private final RentBookService rentBookService;

    @Autowired
    public RentBookController(BookService bookService, ReaderService readerService, RentBookService rentBookService) {
        this.bookService = bookService;
        this.readerService = readerService;
        this.rentBookService = rentBookService;
    }

    @GetMapping("/give/{id}")
    public String give(ModelMap modelMap,
                       @PathVariable int id){

        modelMap.put("book", bookService.getBookById(id));
        modelMap.put("readersList", readerService.getReaders());

        return "give";
    }

    @GetMapping("/giveInBook/{id}")
    public String giveIn (ModelMap modelMap,
                          @PathVariable int id){

        rentBookService.giveInBook(id);
        modelMap.put("booksList", bookService.getBooks());

        return "index";
    }

    @PostMapping("/rentBook")
    public String rentBook(ModelMap modelMap,
                           @RequestParam int readerID,
                           @RequestParam int bookID){

        rentBookService.rentBook(readerID, bookID);
        modelMap.put("booksList", bookService.getBooks());

        return "index";
    }
}
