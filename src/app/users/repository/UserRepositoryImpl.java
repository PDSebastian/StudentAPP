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
    public boolean findByEmail(String email) {
        return this.users.stream().filter(us->us.getEmail().equals(email)).findFirst().isPresent();
    }



    @Override
    public User register(User user) {
        if(findByEmail(user.getEmail())){
            System.out.println("Email"+user.getEmail()+" already exists");
            return user;
        }
        users.add(user);
        System.out.println("User"+user.getEmail()+" registered successfully");
        return user;
    }

    @Override
    public void authenticate(String email, String password) {
        Optional<User> user = this.users.stream().filter(us->us.getEmail().equals(email)).findFirst();
        if(user.isEmpty()){
            System.out.println("User"+email+" not found");
        }
        User u=user.get();
        if(u.getPassword().equals(password)){
            System.out.println("User"+email+" authenticated successfully");
        }
        else{
            System.out.println("Wrong password");
        }

    }

    @Override
    public User deleteUser(User user) {
        users.remove(user);
        return user;
    }


}
