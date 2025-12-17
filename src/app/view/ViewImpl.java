package app.view;
import app.books.model.Book;
import app.books.service.BookComandService;
import app.books.service.BookQueryService;
import app.books.service.BookComandServiceImpl;
import app.books.service.BookQueryServiceImpl;
import app.course.repository.CourseRepositoryImpl;
import app.course.service.CourseComandServiceImpl;
import app.course.service.CoursesQueryServiceImpl;
import app.enrolment.exceptions.UserHasNotBeenAddedToCourseException;
import app.enrolment.repository.EnrolmentRepositoryImpl;
import app.enrolment.service.EnrolmentComandService;
import app.enrolment.service.EnrolmentComandServiceImpl;
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
    EnrolmentComandService enrolmentComandService;
    private  User user;

    public ViewImpl() {
        this.userQueryService=new UserQueryServiceImpl();
        this.userComandService=new UserComandServiceImpl();
        this.bookQueryService=new BookQueryServiceImpl();
        this.bookComandService=new BookComandServiceImpl();
        this.enrolmentComandService = new EnrolmentComandServiceImpl(new EnrolmentRepositoryImpl(), this.userQueryService, this.userComandService, new CoursesQueryServiceImpl(new CourseRepositoryImpl()));
    }

    void meniu(){
        System.out.println("1.Login Users");
        System.out.println("2.Carti imprumutate ");
        System.out.println("3.Afisare nr de carti imprumutate ");
        System.out.println("4.Afisare toate cartiile imprumutate ");
        System.out.println("5.Inrolare student la curs  ");
        System.out.println("6.Retragere student de la curs  ");


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
                       loginUser("student1@gmail.com","password1");
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
                               case "5":
                                   enrolStudent();
                                   break;
                                case "6":
                                    withdrawStudent();
                                    break;
               }
           }

        }
    }
   void loginUser(String email,String password){
        try{
            this.user=this.userComandService.autenticate(email,password);
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
   void enrolStudent(){
        if(this.user==null){
            System.out.println("Error: User is null");
            return;
        }
        Scanner sc=new Scanner(System.in);
        int courseID=Integer.parseInt(sc.nextLine());
        try{
            this.enrolmentComandService.addEnrolment(this.user,courseID);


        } catch (UserHasNotBeenAddedToCourseException e) {
            System.out.println(e.getMessage());
        }


   }
   void withdrawStudent(){
        Scanner sc=new Scanner(System.in);
        int courseID=Integer.parseInt(sc.nextLine());
        try{
            this.enrolmentComandService.removeEnrolment(this.user,courseID);


        }catch (Exception e ){
            System.out.println(e.getMessage());
        }




   }





}
