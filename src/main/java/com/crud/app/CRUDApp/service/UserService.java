package com.crud.app.CRUDApp.service;

import com.crud.app.CRUDApp.dto.UserDTO;
import com.crud.app.CRUDApp.entity.User;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO user);
    UserDTO getUser(Long id);
    List<UserDTO> getUsers();
    UserDTO updateUser(Long id, UserDTO user);
    Boolean deleteUser(Long id);
}
