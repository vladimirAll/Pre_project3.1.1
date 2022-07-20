package org.example.Pre_project311.service;

import org.example.Pre_project311.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    List<User> getAllUsers();

    void deleteUser(Long id);

    User updateUser(User user);

    User findById(Long id);
}
