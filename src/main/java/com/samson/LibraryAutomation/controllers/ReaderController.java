package com.samson.LibraryAutomation.controllers;

import com.samson.LibraryAutomation.services.BookService;
import com.samson.LibraryAutomation.services.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ReaderController {


    private final ReaderService readerService;
    private final BookService bookService;

    @Autowired
    public ReaderController(ReaderService readerService, BookService bookService) {
        this.readerService = readerService;
        this.bookService = bookService;
    }


    @GetMapping("/readers")
    public String mainReader(ModelMap modelMap){

        modelMap.put("readersList", readerService.getReaders());

        return "readers";
    }

    @PostMapping("/addReader")
    public String addReader(ModelMap modelMap,
                            @RequestParam String name, @RequestParam String surname,
                            @RequestParam String address, @RequestParam String email,
                            @RequestParam Float phoneNumber
                            ){

        readerService.addNewReader(name, surname, address, email, phoneNumber);
        modelMap.put("readersList", readerService.getReaders());

        return "readers";
    }


    @GetMapping("/deleteReader/{id}")
    public String deleteReader(ModelMap modelMap,
                               @PathVariable int id){

        readerService.deleteReader(id);
        modelMap.put("readersList", readerService.getReaders());

        return "readers";
    }

    @GetMapping("/infoReader/{id}")
    public String infoReader (ModelMap modelMap,
                              @PathVariable int id){

        modelMap.put("reader", readerService.findReaderById(id));
        modelMap.put("booksList", bookService.getBooks(readerService.findReaderById(id)));

        return "user";
    }

    @GetMapping("/infoReaderByBook/{id}")
    public String infoReaderByBook (ModelMap modelMap,
                                    @PathVariable int id){

        modelMap.put("reader", readerService.findReaderByBookId(id));
        modelMap.put("booksList", bookService.getBooks(readerService.findReaderByBookId(id)));

        return "user";
    }

    @GetMapping("/searchReader")
    public String searchReader(ModelMap modelMap,
                               @RequestParam String name){

        modelMap.put("readersList", readerService.findReaderBySurname(name));

        return "readers";
    }
}
