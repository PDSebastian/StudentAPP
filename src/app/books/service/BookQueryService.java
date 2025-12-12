package app.books.service;

import app.books.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookQueryService {
    List<Book> findAllBooks();
    Optional<Book> findBookById(String bookId);
    boolean borrowedBooks();
    int countBorrowedBooks();
    void showAllBorrowedBooks();
}
