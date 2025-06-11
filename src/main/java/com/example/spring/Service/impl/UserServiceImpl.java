package com.example.spring.Service.impl;

import com.example.spring.Mapper.UserMapper;
import com.example.spring.Repository.UserRepository;
import com.example.spring.Service.UserService;
import com.example.spring.dto.UserDto;
import com.example.spring.entity.User;
import com.example.spring.exception.ResourceNotfound;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service

public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {

      //convert UserDto into jpa
        User user = UserMapper.mapToUser(userDto);

        User savedUser = userRepository.save(user);

        //convert user jpa into dto
        UserDto savedUsedto = UserMapper.mapToUserDto(savedUser);

        return savedUsedto;

    }

    @Override
    public UserDto getUserById(Long Id) {

        User user =userRepository.findById(Id).orElseThrow(
                ()-> new ResourceNotfound("User","id",Id)
        );

        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUser() {

       List<User> users = userRepository.findAll();

        return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).orElseThrow(
                ()-> new ResourceNotfound("User","id",user.getId())
        );
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());

        User updated_user = userRepository.save(existingUser);
        return updated_user;
    }

    @Override
    public String deletedUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                ()-> new ResourceNotfound("User","id",id)
        );
         userRepository.deleteById(id);
         return "User deleted!";
    }
}
