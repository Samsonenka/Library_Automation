package com.samson.LibraryAutomation.services;

import com.samson.LibraryAutomation.models.Reader;
import com.samson.LibraryAutomation.repo.ReaderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderService {

    private final ReaderRepo readerRepo;

    @Autowired
    public ReaderService(ReaderRepo readerRepo) {
        this.readerRepo = readerRepo;
    }


    public List<Reader> getReaders() {
        return readerRepo.findAll();
    }

    public void addNewReader(String name, String surname, String address, String email, int phoneNumber) {

        Reader reader = new Reader(name, surname, address, email, phoneNumber);
        readerRepo.save(reader);
    }

    public void deleteReader(int id) {

        Reader reader = readerRepo.findById(id).get();
        readerRepo.delete(reader);
    }

    public Object findReaderById(int id) {
        return readerRepo.findById(id).get();
    }
}
