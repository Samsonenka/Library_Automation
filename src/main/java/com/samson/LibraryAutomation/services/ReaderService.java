package com.samson.LibraryAutomation.services;

import com.samson.LibraryAutomation.models.Reader;
import com.samson.LibraryAutomation.models.RentBook;
import com.samson.LibraryAutomation.repo.ReaderRepo;
import com.samson.LibraryAutomation.repo.RentBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReaderService {

    private final ReaderRepo readerRepo;
    private final RentBookRepo rentBookRepo;

    @Autowired
    public ReaderService(ReaderRepo readerRepo, RentBookRepo rentBookRepo) {
        this.readerRepo = readerRepo;
        this.rentBookRepo = rentBookRepo;
    }


    public List<Reader> getReaders() {
        return readerRepo.findAll();
    }

    public void addNewReader(String name, String surname, String address, String email, Long phoneNumber) {

        Reader reader = new Reader(name, surname, address, email, phoneNumber);
        readerRepo.save(reader);
    }

    public String deleteReader(int id) {

        Reader reader = findReaderById(id);
        List<RentBook> rentBookList = rentBookRepo.findAll();
        int counter = 0;

        for (RentBook value: rentBookList) {
            if (value.getReader().getId() == reader.getId()){
                counter++;
            }
        }

        if (counter > 0) {
            return "Unable to delete a reader. He has books.";
        }

        readerRepo.delete(reader);

        return "Reader deleted successfully";
    }

    public Reader findReaderById(int id) {
        return readerRepo.findById(id).get();
    }

    public  List<Reader> findReaderBySurname(String name) {

        List<Reader> newReadersList = new ArrayList<>();

        for (Reader value: readerRepo.findAll()) {
            if (value.getSurname().equals(name)){
                newReadersList.add(value);
            }
        }
        return newReadersList;
    }

    public Reader findReaderByBookId(int id) {

        List<RentBook> rentBookList = rentBookRepo.findAll();
        Reader reader = new Reader();

        for (RentBook value: rentBookList) {
            if (value.getBook().getId() == id){
                reader = value.getReader();
            }
        }
        return reader;
    }

}
