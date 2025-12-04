package app.books.repository;

import app.users.model.Student;
import app.users.model.Teacher;
import app.users.model.User;

import app.books.model.Book;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookRepositoryImpl implements BookRepository {
    private List<Book> books;


    public BookRepositoryImpl() {
        this.books = new ArrayList<>();
        this.loadBooks();

    }

    void loadBooks() {
        try {
            Scanner sc = new Scanner(new File("C:\\Users\\adria\\Desktop\\mycode\\java-basics\\StudentAPP\\src\\app\\books\\data"));

            while (sc.hasNextLine()) {
                String line = sc.nextLine();

                switch (line.split(" , ")[0]) {
                    case "BOOK":
                        this.books.add(new Book(line));
                        break;

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Book> findAll() {
        return this.books;
    }
}



