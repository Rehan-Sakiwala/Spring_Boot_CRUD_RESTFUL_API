package com.demo.sbRESTfulWebService.services;

import com.demo.sbRESTfulWebService.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public User createUser(User user);
    public List<User> getAllUsers();
    public Optional<User> getUserById(int id);
    public User updateUserById(int id, User user);
    public void deleteUserById(int id);
}