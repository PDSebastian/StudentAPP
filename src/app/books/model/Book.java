package app.books.model;

import java.time.LocalDate;

public class Book{
     String name;
     String author;
     int idBook;
     int idStudent;
     LocalDate publishDate;

    public String getName(){
        return name;
    }

    public  Book (String text){
        String[] split = text.split(",");
        name = split[0];
        this.author = split[1];
        idBook = Integer.parseInt(split[2]);
        idStudent = Integer.parseInt(split[3]);
        publishDate = LocalDate.parse(split[4]);


    }

    public Book(Builder builder) {
        this.name = builder.name;
        this.author = builder.author;
        this.idBook = builder.idBook;
        this.idStudent=builder.idStudent;
        this.publishDate = builder.publishDate;

    }
    public int  getIdBook() {
        return idBook;
    }
    public int getIDStudent() {
        return idStudent;
    }

    public int setIDBook(int idBook) {
        this.idBook = idBook;
        return idBook;
    }

    public String toString(){
        return "Book: name "+name+" author"+author+" idBook"+idBook+" publishDate"+publishDate;
    }
    public int compareTo(Book b){
        if(this.name.length()<b.name.length()){
            return 1;
        }
        else if(this.name.length()>b.name.length()){
            return -1;
        }
        return 0;
    }
    public boolean equals(Book b){
        if(this.publishDate==b.publishDate){
            return true;
        }
        return false;
    }


    public static class Builder{
        public int idStudent;
        String id;
        String password;
        String email;
        String name;
        String author;
        int idBook;
        LocalDate publishDate;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }
        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }
        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }
        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        public Builder setAuthor(String author) {
            this.author = author;
            return this;
        }
        public Builder setIdBook(int idBook) {
            this.idBook = idBook;
            return this;
        }
        public Builder setPublishDate(LocalDate publishDate) {
            this.publishDate = publishDate;
            return this;

        }
        public Builder setIdStudent(int idStudent) {
            this.idStudent = idStudent;
            return this;
        }
        public Book build() {
            return new Book(this);
        }


    }

}
