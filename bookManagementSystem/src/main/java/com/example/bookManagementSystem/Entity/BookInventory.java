package com.example.bookManagementSystem.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;

/*This class with the annotation @Entity creates a table with the same name as of the class name
 it should compulsorily have a primary key
 */
@Entity
public class BookInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(value=1, message = "book Id must be greater then zero")
   private int bookId;

   private String bookName;
    private String authorName;

    private   float price;
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }






}
