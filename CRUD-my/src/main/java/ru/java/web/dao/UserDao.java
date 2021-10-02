package ru.java.web.dao;

import ru.java.web.models.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    void save(User user);
    void delete (Long id);
    User findById (Long id);
}
