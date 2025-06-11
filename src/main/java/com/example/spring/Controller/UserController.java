package com.example.spring.Controller;


import com.example.spring.Service.UserService;
import com.example.spring.dto.UserDto;
import com.example.spring.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    //http://localhost:8080/api/signup
    @PostMapping("/signup")
    public ResponseEntity<UserDto> createuser(@RequestBody UserDto user){

        UserDto user1 = userService.createUser(user);
       return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }


    //http://localhost:8080/api/3
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getuserbyid(@PathVariable Long id){

        UserDto user =userService.getUserById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);




    }


    @GetMapping("all")
    public ResponseEntity<List<UserDto>> getalluser(){

        List<UserDto> users = userService.getAllUser();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id , @RequestBody User user){
        user.setId(id);
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletedUser(@PathVariable Long id){
        userService.deletedUser(id);
        return new ResponseEntity<>("DeletedUser",HttpStatus.OK);
    }
}
