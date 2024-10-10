package com.example.bookManagementSystem.Service;

import com.example.bookManagementSystem.DAO.BookRequest;
import com.example.bookManagementSystem.Entity.BookInventory;

import java.util.List;
import java.util.Optional;

public interface Serviceint {
    BookInventory saveData(BookRequest req);
    List<BookInventory> readAll();

    String updateData(BookRequest req);

    void deleteRecord(int id);

    List<BookInventory> findAthrName(String AuthorName);

    Optional<BookInventory> findByBookId(int BookId);
}
