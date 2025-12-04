package app.books.repository;

import app.books.model.Book;
import java.util.List;

public interface BookRepository {
    List<Book> findAll();


}
