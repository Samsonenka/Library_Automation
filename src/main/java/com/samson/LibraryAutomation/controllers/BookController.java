package com.samson.LibraryAutomation.controllers;

import com.samson.LibraryAutomation.models.Book;
import com.samson.LibraryAutomation.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookRepo bookRepo;

    @PostMapping("/addBook")
    public String addBook(ModelMap modelMap,
                          @RequestParam String name, @RequestParam String author){

        Book book = new Book(name, author);
        bookRepo.save(book);

        modelMap.put("booksList", bookRepo.findAll());

        return "index";
    }

    @GetMapping("/searchBook")
    public String searchBook(ModelMap modelMap,
                             @RequestParam String name, @RequestParam String filter){

        Book book = new Book();
        List<Book> bookList = book.findBook(bookRepo.findAll(), filter, name);

        modelMap.put("booksList", bookList);

        return "index";
    }

    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable int id){

        return "redirect:/";
    }
}
