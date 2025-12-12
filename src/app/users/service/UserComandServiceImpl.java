package app.users.service;

import app.users.exceptions.UserAlreadyExistException;
import app.users.model.User;
import app.users.repository.UserRepositoryImpl;
import app.users.repository.UsersRepository;

import java.util.Optional;

public class UserComandServiceImpl implements UserCommandService{
    UsersRepository usersRepository;

    public UserComandServiceImpl() {
        this.usersRepository=new UserRepositoryImpl();
    }


    @Override
    public User add(User user) throws UserAlreadyExistException {
      if(usersRepository.findByEmail(user.getEmail()).isPresent()){
        throw  new UserAlreadyExistException();
      }
      Optional<User> u=usersRepository.register(user);
      return u.get();

    }


    @Override
    public User deleteUser(User user) {
       Optional<User>u= usersRepository.deleteUser(user);
       return u.get();
    }

    @Override
    public User autenticate(String email, String password) {
        Optional<User>u=usersRepository.authenticate(email, password);
        return u.get();
    }

}
