package com.crud.app.CRUDApp.mapper;

import com.crud.app.CRUDApp.dto.UserDTO;
import com.crud.app.CRUDApp.entity.User;

public class UserMapper {

    public static UserDTO mapToUserDTO (User user){
        UserDTO userDTO = new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return userDTO;
    }

    public static User mapToUser (UserDTO userDTO){
        User user = new User(
                userDTO.getId(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail()
        );
        return user;
    }
}
