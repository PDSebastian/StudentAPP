package app;

import java.time.LocalDate;
import java.util.Scanner;

import app.books.model.Book;
import app.books.service.*;
import app.users.model.Student;
import app.users.service.UserQueryService;
import app.users.service.UserQueryServiceImpl;
import app.books.service.BookQueryServiceImpl;
import app.books.service.BookQueryServiceImpl;


public class Application {

   UserQueryService userQueryService;
   BookQueryService bookQueryService;
   BookComandService bookComandService;

   public Application(UserQueryService userQueryService,BookQueryService bookQueryService,BookComandService bookComandService) {
       this.userQueryService=userQueryService;
       this.bookQueryService=bookQueryService;
       this.bookComandService=bookComandService;

   }

    void meniu(){
        System.out.println("Meniu: ");
        System.out.println("Apasati tasta 1 pentru a afisa toti studentii ");
        System.out.println("Apasati tasta 2 pentru a afisa toate cartiile ");
        System.out.println("Apasati tasta 3 pentru a adauga o carte ");



    }
    public void app(){

        boolean running=true;
        Scanner sc=new Scanner(System.in);
        while(running){
            meniu();
            if(sc.hasNextLine()){
                String input=sc.nextLine();
                switch (input){
                    case "1":
                      afisareStudenti();
                      break;
                      case "2":
                          afisareCarti();
                          break;
                          case "3":
                            addNewBook();
                            break;


                }


            }
        }





        }


        void afisareStudenti(){
          this.userQueryService.findAll().forEach(System.out::println);
        }
        void afisareCarti(){
            this.bookQueryService.findAllBooks().forEach(System.out::println);

        }
        void addNewBook(){
       Scanner sc=new Scanner(System.in);
           String title=sc.nextLine();
           String author=sc.nextLine();
           String data=sc.nextLine();
           String idBookS=sc.nextLine();
           String idStudentS=sc.nextLine();

           try{
               int idBook= Integer.parseInt(idBookS);
               int idStudent= Integer.parseInt(idStudentS);


               Book book=new Book.Builder().setId("122").setAuthor("Ion").build();
               Book addBook=this.bookComandService.createBook(book);


           }catch(NumberFormatException e){
               System.out.println(e.getMessage());
           }
           System.out.println("Cartile dupa adaugare:");
            afisareCarti();
        }






}
