package com.example.Elearn.service;


import com.example.Elearn.model.User;
import com.example.Elearn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String username) {
        User newUser = new User(username);
        return userRepository.save(newUser);
    }

    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }
}
