package com.samson.LibraryAutomation.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String author;
    private boolean status;

    public Book() {
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
        this.status = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Book> findByName(List<Book> all, String name) {

        List<Book> bookList = new ArrayList<>();

        for (Book value: all) {
            if (value.getName().equals(name)){
                bookList.add(value);
            }
        }
        return bookList;
    }
}
