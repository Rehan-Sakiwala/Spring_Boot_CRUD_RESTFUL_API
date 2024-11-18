package com.demo.sbRESTfulWebService.controllers;

import com.demo.sbRESTfulWebService.entities.User;
import com.demo.sbRESTfulWebService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MyController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public User addUserDetails(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/user")
    public List<User> getAllUserDetails(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id){
        User user = userService.getUserById(id).orElse(null);
        if(user != null){
            return ResponseEntity.ok().body(user);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable int id, @RequestBody User user){
        User updatedUser = userService.updateUserById(id,user);
        if(updatedUser != null){
            return ResponseEntity.ok().body(updatedUser);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable int id){
        userService.deleteUserById(id);
        return ResponseEntity.ok("User deleted");
    }
}
