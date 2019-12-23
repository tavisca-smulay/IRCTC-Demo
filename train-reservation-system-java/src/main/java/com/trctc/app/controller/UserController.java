package com.trctc.app.controller;

import com.trctc.app.model.User;
import com.trctc.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable String id){
        return userService.getUserById(Integer.parseInt(id));
    }

    @PostMapping("/user")
    public ResponseEntity<String> addUser(@RequestBody User user){
        userService.saveUser(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }





}
