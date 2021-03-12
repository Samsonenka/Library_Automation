package com.samson.LibraryAutomation.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class RentBook {

    //проверка на наличие книг

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private LocalDate date;

    @OneToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    @OneToOne
    @JoinColumn(name = "reader_id", referencedColumnName = "id")
    private Reader reader;

    public RentBook() {
    }

    public RentBook(Book book, Reader reader) {
        this.date = LocalDate.now();
        this.book = book;
        this.reader = reader;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }
}
