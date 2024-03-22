package com.userService.userService.service;

import com.userService.userService.model.User;

public interface UserService {
    User saveUser(User user);
    Boolean verifyToken(String token);
}
