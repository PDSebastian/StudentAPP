package app.view;
import app.books.model.Book;
import app.books.service.BookComandService;
import app.books.service.BookQueryService;
import app.books.service.BookComandServiceImpl;
import app.books.service.BookQueryServiceImpl;
import app.users.model.User;
import app.users.service.UserQueryServiceImpl;
import app.users.service.UserComandServiceImpl;
import app.users.service.UserQueryService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ViewImpl implements View {
   private UserQueryService userQueryService;
    UserComandServiceImpl userComandService;
    BookQueryService bookQueryService;
    BookComandService bookComandService;
    private  User user;

    public ViewImpl() {
        this.userQueryService=new UserQueryServiceImpl();
        this.userComandService=new UserComandServiceImpl();
        this.bookQueryService=new BookQueryServiceImpl();
        this.bookComandService=new BookComandServiceImpl();
    }

    void meniu(){
        System.out.println("1.Login Users");
        System.out.println("2.Carti imprumutate ");
        System.out.println("3.Afisare nr de carti imprumutate ");
        System.out.println("4.Afisare toate cartiile imprumutate ");


    }

    @Override
    public void play() {
        meniu();
        boolean run=true;
        Scanner sc=new Scanner(System.in);
        while(run){
           if(sc.hasNextLine()){
               String line=sc.nextLine();
               switch (line){
                   case "1":
                       loginUser("1student1@gmail.com","password1");
                       break;
                   case "2":
                       showBooksUser();
                       break;
                       case "3":
                           ctBorroedBooks();
                           break;
                           case "4":
                               showAllBorrowedBooks();
                               break;

               }
           }

        }
    }
   void loginUser(String email,String password){
        try{
            this.userComandService.autenticate(email,password);
            System.out.println("Logare reusita");
        }catch (Exception e){
            System.out.println(e.getMessage());

        }


   }
   void showBooksUser(){
        Scanner sc=new Scanner(System.in);
        String userID=sc.nextLine();

        try{
            Optional<Book> b=this.bookQueryService.findBookById(userID);
            if(b.isEmpty()){
                System.out.println("User"+userID+" nu am imprumutat carti");
            }else{
                System.out.println("Carti imprumutate de "+userID+" sunt: ");
                b.ifPresent(book->System.out.println(b.toString()));
            }



        } catch (Exception e) {
           System.out.println(e.getMessage());
        }

   }
   void ctBorroedBooks(){
        int nr=bookQueryService.countBorrowedBooks();
        if(nr>0){
            System.out.println("Nr de carti imprumutate este: "+bookQueryService.countBorrowedBooks());
        }
        else {
            System.out.println("Nu exista carti imprumutate ");
        }
   }
   void showAllBorrowedBooks(){
        bookQueryService.showAllBorrowedBooks();

   }





}
