package com.aababou.springboot.mapper;

/*
author otman
    */

import com.aababou.springboot.dto.UserDto;
import com.aababou.springboot.entity.User;

public class UserMapper {
    //converting UserDto to User JPA ENTITY
    public static User toUserEntity(UserDto userdto) {
        User user = new User(
                userdto.getId(),
                userdto.getFirstName(),
                userdto.getLastName(),
                userdto.getEmail()
        );
        return user;
    }

    //converting User JPA ENTITY to UseDto
    public static UserDto toUserDto(User user) {
        UserDto userDto = new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return userDto;
    }
}
