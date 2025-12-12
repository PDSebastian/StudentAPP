package app.users.service;

import app.users.exceptions.UserAlreadyExistException;
import app.users.exceptions.UserAlreadyHasBeenDeletedException;
import app.users.exceptions.UserHasAlreadyBeenauthenticatedException;
import app.users.model.User;

public interface UserCommandService {
 User add(User user) throws UserAlreadyExistException;
 User deleteUser(User user) throws UserAlreadyHasBeenDeletedException;
 User autenticate(String email, String password) throws UserHasAlreadyBeenauthenticatedException;






}
