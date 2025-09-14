package com.aababou.springboot.service;

import com.aababou.springboot.dto.UserDto;
import com.aababou.springboot.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

/*
author otman
    */

public interface UserService {
     UserDto createUser(UserDto user) ;
     User getUserById(Long id);
     List<User> getAllUsers();
     User updateUser(Long id, User user);
     void deleteUser(Long id);

}
