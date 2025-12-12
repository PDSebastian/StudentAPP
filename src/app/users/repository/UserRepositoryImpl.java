package app.users.repository;

import app.users.model.Student;
import app.users.model.Teacher;
import app.users.model.User;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class UserRepositoryImpl implements UsersRepository {


    private List<User> users;

    public UserRepositoryImpl() {
        this.users = new ArrayList<>();
        this.loadUsers();
    }

    private void loadUsers() {

        try{
            Scanner sc = new Scanner(new File("C:\\Users\\adria\\Desktop\\mycode\\java-basics\\StudentAPP\\src\\app\\users\\data\\users.txt"));

            while (sc.hasNextLine()) {
                String line = sc.nextLine();

                switch (line.split(",")[0]) {
                    case "STUDENT":
                        this.users.add(new Student(line));
                        break;
                    case "USER":
                        this.users.add(new User(line));
                        break;
                    case "TEACHER":
                        this.users.add(new Teacher(line));
                        break;

                }





            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return users.stream().filter(user -> user.getEmail().equals(email)).findFirst();
    }

    @Override
    public Optional<User> register(User user) {
     Optional<User> u = this.findByEmail(user.getEmail());
     if(u.isPresent()){
         System.out.println("User already exists");
     }
     else{
         this.users.add(user);
     }
     return Optional.of(user);
    }

    @Override
    public Optional<User> authenticate(String email, String password) {
        Optional<User> user = findByEmail(email);
        if(user.filter(u->u.getPassword().equals(password)).isPresent() ) {
           System.out.println("User authenticated");

        }
        return user;


    }
    @Override
    public Optional<User> deleteUser(User user) {
        Optional<User> optionalUser = this.users.stream().filter(us->us.getEmail().equals(user.getEmail())).findFirst();
        if(optionalUser.isPresent()){
            this.users.remove(optionalUser.get());
        }
        return Optional.of(user);



    }

    @Override
    public List<User> viewUser() {
        return users;

    }


}
