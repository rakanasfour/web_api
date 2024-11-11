package com.radol.service;

import java.util.List;

import com.radol.dto.UserDTO;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    UserDTO getUserById(Integer userId);
    List<UserDTO> getAllUsers();
    UserDTO updateUser(Integer userId, UserDTO userDTO);
    void deleteUser(Integer userId);
}