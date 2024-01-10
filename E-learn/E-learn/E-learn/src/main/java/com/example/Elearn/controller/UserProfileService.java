package com.example.Elearn.controller;

import com.example.Elearn.model.User;
import com.example.Elearn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

    private final UserRepository userRepository;
    private String password;
    private String email;

    @Autowired
    public UserProfileService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String username) {
        User newUser = new User(username, password, email);
        return userRepository.save(newUser);
    }

    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }
}
