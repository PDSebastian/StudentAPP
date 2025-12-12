package app.books.service;

import app.books.model.Book;
import app.books.repository.BookRepository;
import app.books.repository.BookRepositoryImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookQueryServiceImpl implements BookQueryService {
    private BookRepository bookRepository;

    public BookQueryServiceImpl() {
        this.bookRepository=new BookRepositoryImpl();
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

    @Override
    public boolean borrowedBooks() {
      return   bookRepository.findAll().stream().anyMatch(book -> book.getIDStudent()>0);
    }

    @Override
    public int countBorrowedBooks() {
      return (int)  bookRepository.findAll().stream().filter(book -> book.getIDStudent() > 0).count();

    }

    @Override
    public void showAllBorrowedBooks() {
        bookRepository.findAll().stream().forEach(book -> System.out.println(book.getName()));
    }


}
