package com.RestDemo.RestDemo.repository;

import com.RestDemo.RestDemo.dto.CreateUserDto;
import com.RestDemo.RestDemo.dto.UserDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Repository
public class UserRepository {

    List<UserDto> users = new ArrayList<>();

    public UserRepository() {

        //THe below code is the same as (new UserDto(........))
//        UserDto user = new UserDto(1L, "Man", "man@gmail.com");
//        users.add(user);
//        users.add(new UserDto("1", "Man", "man@gmail.com"));
        users.add(new UserDto(UUID.randomUUID().toString(), "Man", "man@gmail.com"));
        users.add(new UserDto(UUID.randomUUID().toString(), "ankush", "aman@gmail.com"));
        users.add(new UserDto(UUID.randomUUID().toString(), "Prajapati", "bman@gmail.com"));

    }

    public List<UserDto> findAll() {
        return this.users;
    }

    public UserDto findUserById(String id) {
        for (UserDto user : users) {
            //Objects.equals(user.getId(), id) this is basically enhance version of user.getId()== id
            if (Objects.equals(user.getId(), id)) {
                return user;
            }
        }
        return null;
    }

    public UserDto save(CreateUserDto createUserDto) {
        UserDto user =
                new UserDto(
                        UUID.randomUUID().toString(),
                        createUserDto.getName(),
                        createUserDto.getEmail()
                );
        users.add(user);
        return user;
    }

    public UserDto update(CreateUserDto updateUserDto, String id) {
        for (UserDto user : users) {
            if (user.getId().equals(id)) {
                user.setName(updateUserDto.getName());
                user.setEmail(updateUserDto.getEmail());
            }
            return user;
        }
        return null;
    }

    public void deleteUserById(String id) {
        users.removeIf(userDto -> userDto.getId().equals(id));
    }
}
