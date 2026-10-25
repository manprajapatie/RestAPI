package com.RestDemo.RestDemo.service;

import com.RestDemo.RestDemo.dto.CreateUserDto;
import com.RestDemo.RestDemo.dto.UserDto;
import com.RestDemo.RestDemo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void deleteUserById(String id) {
        userRepository.deleteUserById(id);
    }

    public List<UserDto> getAllUsers() {
        return this.userRepository.findAll();
    }

    public UserDto getUserById(String id) {
        return userRepository.findUserById(id);
    }

    public UserDto createUser(CreateUserDto createUserDto) {
        return userRepository.save(createUserDto);
    }

    public UserDto updateUser(CreateUserDto updateUserDto, String id) {
        if (userRepository.findUserById(id) == null) {
            return null;
        }
        return userRepository.update(updateUserDto, id);
    }
}
