package com.RestDemo.RestDemo.controller;

import com.RestDemo.RestDemo.dto.CreateUserDto;
import com.RestDemo.RestDemo.dto.UserDto;
import com.RestDemo.RestDemo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    //Get all the user
    @GetMapping
//    @GetMapping("")
    //we will return multiple objects that's why we are writing List
    public ResponseEntity<List<UserDto>> getAllUser() {
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.getAllUsers());
    }

    //Get User By Id
    @GetMapping("/{id}")
//    public UserDto getUserById(@PathVariable Long id){
//        return userService.getUserById(id);
//    }
    //we are adding http response here
    public ResponseEntity<UserDto> getUserById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }

    //Create User
//    @PostMapping
//    public ResponseEntity<UserDto> createUser()

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserDto createUserDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(createUserDto));
    }

    //Update user object
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody CreateUserDto updateUserDto, @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(updateUserDto, id));
    }


    //Delete User
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable String id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

}
