package com.aababou.springboot.controller;

import com.aababou.springboot.dto.UserDto;
import com.aababou.springboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
author otman
    */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Create User
    //Localhost:8080/users/create
    // build create User REST API
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    //Get User
    //Localhost:8080/users/1
    // build get User REST API
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id){
        UserDto user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //Get All User
    //Localhost:8080/users
    // build get AllUsers REST API
    @GetMapping
    public ResponseEntity<List<UserDto>> getUser(){
        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //Update User
    //Localhost:8080/users/1
    // build update User REST API
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto user){
        UserDto updateUser = userService.updateUser(id, user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    //Delete User
    //Localhost:8080/users
    // build delete User REST API
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
       userService.deleteUser(id);
       return "User deleted successfully";
    }
}
