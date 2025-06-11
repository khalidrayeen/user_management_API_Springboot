package com.example.spring.Service;

import com.example.spring.dto.UserDto;
import com.example.spring.entity.User;

import java.util.List;

public interface UserService {

     UserDto createUser(UserDto user);

     UserDto getUserById(Long Id);

     List<UserDto> getAllUser();

     User updateUser(User user);

     String deletedUser(Long id);
}
