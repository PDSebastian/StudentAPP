package app.books.repository;

import app.books.model.Book;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BookRepositoryImpl implements BookRepository {
    private List<Book> books;


    public BookRepositoryImpl() {
        this.books = new ArrayList<>();
        this.loadBooks();

    }

    void loadBooks() {
        try{
            Scanner sc =new  Scanner(new File("C:\\Users\\adria\\Desktop\\mycode\\java-basics\\StudentAPP\\src\\app\\books\\data\\book.txt"));

            while(sc.hasNextLine()){
               this.books.add(new Book(sc.nextLine()));

            }

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }


    }

    @Override
    public List<Book> findAll() {
        return this.books;
    }

    @Override
    public Book addBook(Book book) {
       book.setIDBook(generateID());
       books.add(book);
        return book;

    }
    @Override
    public Book delete(Book book) {
        books.remove(books);
        return book;
    }
    @Override
    public int randomID() {
        Random rand = new Random();
        int id=rand.nextInt(100)+1;
        return id;
    }
    @Override
    public int generateID() {
        int id=randomID();
        while(getBookByID(id)!=null){
            id=randomID();

        }
        return id;
    }
    @Override
    public Book getBookByID(int id) {
        return books.stream().filter(books-> books.getIdBook()==id).findFirst().orElse(null);
    }



}



