package app.users.service;

import app.users.exceptions.UserAlreadyExistException;
import app.users.model.User;

public interface UserCommandService {
 User add(User user) throws UserAlreadyExistException;
 User deleteUser(User user);
 User autenticate(String email, String password);






}
