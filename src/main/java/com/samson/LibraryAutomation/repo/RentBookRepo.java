package com.samson.LibraryAutomation.repo;

import com.samson.LibraryAutomation.models.RentBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentBookRepo extends JpaRepository<RentBook, Integer> {
}
