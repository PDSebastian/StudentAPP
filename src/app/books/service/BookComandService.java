package app.books.service;

import app.books.model.Book;

public interface BookComandService {
    Book createBook(Book book);
    Book deleteBook(Book book);


}
