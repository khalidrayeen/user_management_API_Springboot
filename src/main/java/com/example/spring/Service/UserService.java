package com.example.spring.Service;

import com.example.spring.entity.User;

import java.util.List;

public interface UserService {

     User createUser(User user);

     User getUserById(Long Id);

     List<User> getAllUser();

     User updateUser(User user);

     String deletedUser(Long id);
}
