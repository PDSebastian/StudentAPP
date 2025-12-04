import app.books.repository.BookRepository;
import app.books.repository.BookRepositoryImpl;
import app.users.model.Student;
import app.users.model.Teacher;
import app.users.repository.UserRepositoryImpl;
import app.users.repository.UsersRepository;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main(String[] args) {


    UsersRepository usersRepository= new UserRepositoryImpl();
    usersRepository.findAll().stream().forEach(System.out::println);

    BookRepository bookRepository = new BookRepositoryImpl();
    bookRepository.findAll().stream().forEach(System.out::println);



}
