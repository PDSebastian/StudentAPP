package app.users.service;

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
    public User add(User user) {
        return usersRepository.register(user);



    }

    @Override
    public User deleteUser(User user) {
        return usersRepository.deleteUser(user);
    }

    @Override
    public User autenticate(String email, String password) {
        return usersRepository.authenticate(email, password);
    }
}
