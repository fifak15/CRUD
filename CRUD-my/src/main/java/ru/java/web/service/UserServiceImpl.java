package ru.java.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.java.web.models.User;
import ru.java.web.dao.UserDao;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    final UserDao repository;

    @Autowired
    public UserServiceImpl(UserDao repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getAllUsers() {
        return repository.getAllUsers();
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id);
    }
}
