package com.yatralink.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yatralink.model.User;
import com.yatralink.repository.UserRepository;
import com.yatralink.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserByEmail(String email) {
       return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
       return userRepository.findAll();
    }


}
