package app.users.repository;

import app.users.model.User;

import java.util.List;

public interface UsersRepository {

    List<User> findAll();
    boolean findByEmail(String email);
    User register(User user);
    void authenticate(String email, String password);
    User deleteUser(User user);
}
