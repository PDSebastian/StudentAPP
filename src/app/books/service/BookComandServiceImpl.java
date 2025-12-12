package app.books.service;

import app.books.model.Book;
import app.books.repository.BookRepository;
import app.books.repository.BookRepositoryImpl;

public class BookComandServiceImpl implements BookComandService {
    private BookRepository bookRepository;
    public BookComandServiceImpl() {
        this.bookRepository=new BookRepositoryImpl();
    }
    @Override
    public Book createBook(Book book) {

       return bookRepository.addBook(book);
    }

    @Override
    public Book deleteBook(Book book) {
        return bookRepository.delete(book);
    }
}
