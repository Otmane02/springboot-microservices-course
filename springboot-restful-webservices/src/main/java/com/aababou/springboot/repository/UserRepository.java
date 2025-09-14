package com.aababou.springboot.repository;

import com.aababou.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/*
author otman
    */


public interface UserRepository extends JpaRepository<User, Long> {
}
