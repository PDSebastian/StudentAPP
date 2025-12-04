package app.users.repository;

import app.users.model.Student;
import app.users.model.Teacher;
import app.users.model.User;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
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

}
