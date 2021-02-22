package com.samson.LibraryAutomation.controllers;

import com.samson.LibraryAutomation.models.Book;
import com.samson.LibraryAutomation.repo.BookRepo;
import com.samson.LibraryAutomation.services.BookService;
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

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String mainBook(ModelMap modelMap){

        modelMap.put("booksList", bookService.getBooks());

        return "index";
    }

    @PostMapping("/addBook")
    public String addBook(ModelMap modelMap,
                          @RequestParam String name, @RequestParam String author){

        bookService.addNewBook(name, author);
        modelMap.put("booksList", bookService.getBooks());

        return "index";
    }

    @GetMapping("/searchBook")
    public String searchBook(ModelMap modelMap,
                             @RequestParam String name, @RequestParam String filter){

        Book book = new Book();
        List<Book> bookList = book.findBook(bookService.getBooks(), filter, name);

        modelMap.put("booksList", bookList);

        return "index";
    }

//    @GetMapping("/deleteBook/{id}")
//    public String deleteBook(@PathVariable int id){
//
//        Book book = bookRepo.findById(id).get();
//        bookRepo.delete(book);
//
//        return "redirect:/";
//    }
}
