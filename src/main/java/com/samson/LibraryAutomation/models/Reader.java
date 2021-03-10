package com.samson.LibraryAutomation.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String surname;
    private String address;
    private String email;
    private Float phoneNumber;

    //изменить тип номер телефона

    public Reader() {
    }

    public Reader(String name, String surname, String address, String email, Float phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public List<Reader> findBySurname(List<Reader> readerList, String filter){

        List<Reader> newReaderList = new ArrayList<>();

        for (Reader value: readerList) {
            if (value.getSurname().equals(filter)){
                newReaderList.add(value);
            }
        }
        return newReaderList;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Float phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
