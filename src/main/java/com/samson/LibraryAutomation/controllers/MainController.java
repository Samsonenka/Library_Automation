package com.samson.LibraryAutomation.controllers;

import com.samson.LibraryAutomation.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private BookRepo bookRepo;

    @GetMapping("/")
    public String index(ModelMap modelMap){

        modelMap.put("booksList", bookRepo.findAll());

        return  "test";
    }
}
