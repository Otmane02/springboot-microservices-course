package com.aababou.springboot.service;

/*
author otman
    */

import com.aababou.springboot.dto.UserDto;
import com.aababou.springboot.entity.User;
import com.aababou.springboot.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDto createUser(UserDto user) {
        User newUser = new User(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        User savedUser =  userRepository.save(newUser);
        UserDto userDto = new UserDto(
                savedUser.getId(),
                savedUser.getFirstName(),
                savedUser.getLastName(),
                savedUser.getEmail()
        );

        return userDto;
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    @Override
    public List<User> getAllUsers() {
       return  userRepository.findAll();

    }

    @Override
    public User updateUser(Long id, User user) {
        User userToUpdate = userRepository.findById(id).get();
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setEmail(user.getEmail());
        User savedUser = userRepository.save(userToUpdate);
        return savedUser;

    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
        return;
    }
}
