package com.crud.app.CRUDApp.service.impl;

import com.crud.app.CRUDApp.dto.UserDTO;
import com.crud.app.CRUDApp.entity.User;
import com.crud.app.CRUDApp.exception.EmailAlreadyExistsException;
import com.crud.app.CRUDApp.exception.ResourceNotFoundException;
import com.crud.app.CRUDApp.mapper.UserMapper;
import com.crud.app.CRUDApp.repository.UserRepository;
import com.crud.app.CRUDApp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO user) {
        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
        if(optionalUser.isPresent()){
            throw new EmailAlreadyExistsException("Email Already Exists for User");
        }
        User tempUser = UserMapper.mapToUser(user);
        User savedUser = userRepository.save(tempUser);
        return UserMapper.mapToUserDTO(savedUser);
    }

    @Override
    public UserDTO getUser(Long id){
        try {
            Optional<User> optionalUser = userRepository.findById(id);
            UserDTO userDTO = UserMapper.mapToUserDTO(optionalUser.get());
            return userDTO;
        } catch (Exception e){
            throw new ResourceNotFoundException("User", "ID", id);
        }
    }

    @Override
    public List<UserDTO> getUsers(){
        List<User> users = userRepository.findAll();
        List<UserDTO> usersDTO = new ArrayList<UserDTO>();
        for(User user:users){
            UserDTO userDTO = UserMapper.mapToUserDTO(user);
            usersDTO.add(userDTO);
        }
        return usersDTO;
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO user){
        user.setId(id);
        User tempUser = UserMapper.mapToUser(user);
        User updatedUser = userRepository.save(tempUser);
        UserDTO userDTO = UserMapper.mapToUserDTO(updatedUser);
        return userDTO;
    }

    public Boolean deleteUser(Long id) {
        userRepository.deleteById(id);
        return true;
    }
}
