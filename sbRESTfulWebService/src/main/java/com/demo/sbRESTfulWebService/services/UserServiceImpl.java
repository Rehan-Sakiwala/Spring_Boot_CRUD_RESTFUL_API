package com.demo.sbRESTfulWebService.services;

import com.demo.sbRESTfulWebService.entities.User;
import com.demo.sbRESTfulWebService.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public User updateUserById(int id, User newUser) {
        User userData = userRepository.findById(id).orElse(null);
        if(userData != null){
            return userRepository.save(newUser);
        }
        else{
            throw new RuntimeException("User not found with id : "+id);
        }
    }

    @Override
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }


}
