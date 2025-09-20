package com.example.unoproject.service;

import com.example.unoproject.model.User;
import com.example.unoproject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public int addUser(User user) {
        return userRepository.save(user);
    }
}
