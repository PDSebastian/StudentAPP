package app.users.service;

import app.users.model.Student;
import app.users.model.User;
import app.users.repository.UserRepositoryImpl;
import app.users.repository.UsersRepository;

import java.util.List;
import java.util.Optional;

public class UserQueryServiceImpl implements UserQueryService {

    private UsersRepository usersRepository;

    public UserQueryServiceImpl(UsersRepository usersRepository) {
        this.usersRepository=usersRepository;
    }

    public void setUsersRepository(UsersRepository usersRepository) {
        this.usersRepository = new UserRepositoryImpl();
    }
    @Override
    public List<User> findAll() {
        return  usersRepository.findAll();
    }




}
