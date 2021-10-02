package ru.java.web.service;

import ru.java.web.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void save(User user);
    void delete (Long id);
    User findById (Long id);
}
