package com.example.bookManagementSystem.Controller;

import com.example.bookManagementSystem.DAO.BookRequest;
import com.example.bookManagementSystem.Entity.BookInventory;
import com.example.bookManagementSystem.Service.Serviceint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
// First Point of Contact from the U.I/POSTMAN  (i.e. Client)
@RestController
public class APIMapping {

    @Autowired
    Serviceint service;

    /*
    * The below Controller takes data in the form of JSON
    * and INSERTS into the table (book_inventory) in MySql
    * CREATE/SAVE/INSERT API
    * */
    @PostMapping("/api/insert")
    public BookInventory saveData(@RequestBody BookRequest req){
       return service.saveData(req);
    }




    /*
    * The Below Controller retrieves all the record from the DataBase
    * it uses the findAll() method of the Jpa Repository
    * and returns the data in the form of "List"
    * */
    @GetMapping("/api/readAll")
    public List<BookInventory> getall(){
        return service.readAll();
    }




/*
* This Controller will give all records which will have the same Author Name
*
* */
    @GetMapping("/api/readAuthName/{AuthorName}")
    public List<BookInventory> getByAuthorName(@PathVariable String AuthorName){
        return service.findAthrName(AuthorName);
    }


    @GetMapping("/api/readBook/{bookId}")
    public Optional<BookInventory> getBookbyId(@PathVariable int bookId){
        return service.findByBookId(bookId);
    }


    /*
    * The Below  Controller UPDATES an Existing record in the DataBase; it uses the
    * save() method of the Jpa Repository
    * if a particular Record with that book ID is found; then it Updates the records,
    * Otherwise if no such existing record is found it throws a Runtime Exception
    * */
    @PutMapping("/api/update")
    public String updateData(@RequestBody BookRequest req){
        return service.updateData(req);
    }





    /*
    * The Below Controller is used to delete and Existing record
    * is takes BookId as an I/P and deletes that particular record from the Database
    *
    * DRAWBACKS:-  Even if the records is not present in the Database still the Response CODE is:200(OK)
    * */
    @DeleteMapping("/api/delete/{id}")
    public void deleteRecord(@PathVariable int id){

        service.deleteRecord(id);
    }
}
