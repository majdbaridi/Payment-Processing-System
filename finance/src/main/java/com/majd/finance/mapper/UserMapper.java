package com.majd.finance.mapper;

import com.majd.finance.DTO.UserRequest;
import com.majd.finance.DTO.UserResponse;
import com.majd.finance.entity.User;

public class UserMapper {

    public static User toEntity(UserRequest userRequest) {
        return User.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .build();
    }

    public static UserResponse toResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
