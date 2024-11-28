package com.majd.finance.service;

import com.majd.finance.DTO.UserRequest;
import com.majd.finance.DTO.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);
    List<UserResponse> getAllUsers();
    UserResponse getUserById(Long userId);
}
