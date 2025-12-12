package app.users.repository;

import app.users.model.User;

import java.util.List;
import java.util.Optional;

public interface UsersRepository {

    List<User> findAll();
    Optional<User> findByEmail(String email);
    Optional<User> register(User user);
   Optional<User> authenticate(String email, String password);
    Optional<User> deleteUser(User user);
    List<User> viewUser();

}
