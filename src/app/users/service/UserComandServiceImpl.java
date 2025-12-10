package app.users.service;

import app.users.model.User;
import app.users.repository.UsersRepository;

import java.util.Optional;

public class UserComandServiceImpl implements UserCommandService{
    UsersRepository usersRepository;
    public UserComandServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    @Override
    public User add(User user) {
        return usersRepository.register(user);



    }

    @Override
    public User deleteUser(User user) {
        return usersRepository.deleteUser(user);
    }
}
