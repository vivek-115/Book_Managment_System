package com.example.bookManagementSystem.Service;

import com.example.bookManagementSystem.DAO.BookRequest;
import com.example.bookManagementSystem.Entity.BookInventory;
import com.example.bookManagementSystem.Repositry.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/* ALL the Business Logic(CRUD Operations)logic is Written here*/
@Service
public class ServiceImp implements Serviceint{

    @Autowired
    BookRepo repo;

    //Logic to insert the data(Book information) in the dataBase
    @Override
    public BookInventory saveData(BookRequest req) {
        BookInventory book=new BookInventory();
        book.setBookName(req.getBookName());
        book.setAuthorName(req.getAuthorName());
        book.setPrice(req.getPrice());

        return repo.save(book);
    }


    //logic to get List of all the books in the Database
    @Override
    public List<BookInventory> readAll() {
        return repo.findAll();
    }


    //Logic to update an existing record having same Author name
    @Override
    public String updateData(BookRequest req) {
    Optional<BookInventory>existingbook= repo.findById(req.getBookId());

    if (existingbook.isPresent()){
        BookInventory book = existingbook.get();
        book.setBookName(req.getBookName());
        book.setAuthorName(req.getAuthorName());
        book.setPrice(req.getPrice());

         repo.save(book);
         return "RECORD UPDATED SUCCESSFULLY"+" [BOOK NAME: "+book.getBookName()+" , AUTHOR NAME: "+book.getAuthorName()+" , PRICE:"+book.getPrice();
    }else {
      //  throw new RuntimeException("Book Not found");
        return  "No Such Record Found";
    }

    }


    /*Logic to Delete a Record
     Uses Jpa repository method [deleteById() method]
     */
    @Override
    public void deleteRecord(int id) {
        repo.deleteById(id);
    }

    //Logic to find Lists of Book with same Author Name
    @Override
    public List<BookInventory> findAthrName(String AuthorName) {
        return repo.findByAuthorName(AuthorName);
    }

    //Logic to find Book by using BookID
    @Override
    public Optional<BookInventory> findByBookId(int BookId) {
        return repo.findById(BookId);

    }
}
