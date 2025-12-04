package app.users.repository;

import app.users.model.User;

import java.util.List;

public interface UsersRepository {

    List<User> findAll();
}
