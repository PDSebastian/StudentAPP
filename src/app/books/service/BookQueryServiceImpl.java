package app.books.service;

import app.books.model.Book;
import app.books.repository.BookRepository;

import java.util.List;
import java.util.Optional;

public class BookQueryServiceImpl implements BookQueryService {
    private BookRepository bookRepository;
    public BookQueryServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findBookById(String bookId) {
        int id=Integer.parseInt(bookId);
        return Optional.ofNullable(bookRepository.getBookByID(id));
    }
}
