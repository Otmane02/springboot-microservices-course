package com.aababou.springboot.mapper;

import com.aababou.springboot.dto.UserDto;
import com.aababou.springboot.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/*
author otman
    */
@Mapper
public interface AutoUserMapper {

        AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);
        //provide implementation for our interface at a compilation time
   // @Mapping(source = "email",target = "emailAddress")
    UserDto mapToUserDto(User user);
    User mapToUser(UserDto userDto);
}
