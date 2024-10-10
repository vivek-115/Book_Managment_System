package com.example.bookManagementSystem.Repositry;

import com.example.bookManagementSystem.Entity.BookInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/*
* This class inherits the properties from the JpaRepository (It is a Marker interface)
* to perform all the SQL Queries
* */
@Repository
public interface BookRepo extends JpaRepository<BookInventory, Integer> {
    List<BookInventory>findByAuthorName(@Param("AuthorName") String AuthorName);
}
