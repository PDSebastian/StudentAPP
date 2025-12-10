package app.books.repository;

import app.books.model.Book;
import java.util.List;
import java.util.Random;

public interface BookRepository {
    List<Book> findAll();
    Book addBook(Book book);
    Book delete(Book book);
    int randomID();
    int generateID();
    Book getBookByID(int id);


}
