package com.aababou.springboot.service;

/*
author otman
    */

import com.aababou.springboot.dto.UserDto;
import com.aababou.springboot.entity.User;
import com.aababou.springboot.mapper.UserMapper;
import com.aababou.springboot.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public UserDto createUser(UserDto user) {
//        User newUser = UserMapper.toUserEntity(user);
        User newUser = modelMapper.map(user, User.class);
        User savedUser =  userRepository.save(newUser);
//
        UserDto userDto = modelMapper.map(savedUser, UserDto.class);

        return userDto;
    }

    @Override
    public UserDto getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
//        UserDto userDto = UserMapper.toUserDto(user.get());
        UserDto userDto = modelMapper.map(user.get(), UserDto.class);
        return userDto;
    }

    @Override
    public List<UserDto> getAllUsers() {
       List<User> users =   userRepository.findAll();

//      return users.stream()
//               .map(UserMapper::toUserDto)
//               .collect(Collectors.toList());

        return users.stream()
                .map(user->modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());


    }

    @Override
    public UserDto updateUser(Long id, UserDto user) {
        User userToUpdate = userRepository.findById(id).get();

        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setEmail(user.getEmail());
        User savedUser = userRepository.save(userToUpdate);
//        UserDto userDto = UserMapper.toUserDto(savedUser);
        UserDto userDto = modelMapper.map(savedUser, UserDto.class);
        return userDto;

    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
        return;
    }
}
