package com.yatralink.service;

import java.util.List;

import com.yatralink.model.User;

public interface UserService {
    User registerUser(User user);
    User getUserByEmail(String email);
    List<User> getAllUsers();

}
