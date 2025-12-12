import app.books.repository.BookRepository;
import app.books.repository.BookRepositoryImpl;
import app.books.service.BookComandService;
import app.books.service.BookComandServiceImpl;
import app.books.service.BookQueryService;
import app.books.service.BookQueryServiceImpl;
import app.users.repository.UserRepositoryImpl;
import app.users.repository.UsersRepository;
import app.users.service.UserQueryService;
import app.users.service.UserQueryServiceImpl;
import app.view.ViewImpl;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main(String[] args) {

        UsersRepository usersRepository= new UserRepositoryImpl();
        BookRepository bookRepository=new BookRepositoryImpl();

    UserQueryService userQueryService=new UserQueryServiceImpl();
    BookQueryService bookQueryService=new BookQueryServiceImpl();
    BookComandService bookComandService=new BookComandServiceImpl();

//
//    Application application = new Application(userQueryService,bookQueryService,bookComandService);
//    application.app();


    ViewImpl view = new ViewImpl();
    view.play();

}
