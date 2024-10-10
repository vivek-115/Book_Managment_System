package com.example.bookManagementSystem.DAO;


/*
This class is used to handle the data, or you can say store the data coming from the client(in the form of @RequestBody
and then Object of this class is transfer to the Entity class so that the data can be stored in the
database.
 */
public class BookRequest {
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


    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
