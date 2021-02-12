package com.samson.LibraryAutomation.controllers;

import com.samson.LibraryAutomation.models.Reader;
import com.samson.LibraryAutomation.repo.ReaderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReaderController {

    @Autowired
    private ReaderRepo readerRepo;

    @PostMapping("/addReader")
    public String addReader(ModelMap modelMap,
                            @RequestParam String name, @RequestParam String surname,
                            @RequestParam String address, @RequestParam String email,
                            @RequestParam int phoneNumber
                            ){

        Reader reader = new Reader();
        readerRepo.save(reader);

        modelMap.put("readersList", readerRepo.findAll());

        return "index";
    }

    @GetMapping("/infoReader/{id}")
    public String infoReader (ModelMap modelMap,
                              @PathVariable int id){

        Reader reader = readerRepo.findById(id).get();

        modelMap.put("reader", reader);

        return "info";
    }
}
