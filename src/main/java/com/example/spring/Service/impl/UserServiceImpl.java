package com.example.spring.Service.impl;

import com.example.spring.Repository.UserRepository;
import com.example.spring.Service.UserService;
import com.example.spring.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service

public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {

        User user1 = userRepository.save(user);
        return user1;

    }

    @Override
    public User getUserById(Long Id) {

        Optional<User> optionalUser=userRepository.findById(Id);
        return optionalUser.get();
    }

    @Override
    public List<User> getAllUser() {

        List<User>userList = userRepository.findAll();
        return userList;
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());

        User updated_user = userRepository.save(existingUser);
        return updated_user;
    }

    @Override
    public String deletedUser(Long id) {
         userRepository.deleteById(id);
         return "User deleted!";
    }
}
