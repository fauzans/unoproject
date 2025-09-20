package com.example.unoproject.controller;

import com.example.unoproject.model.User;
import com.example.unoproject.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/insert")
    public String createUser(@RequestBody User user) {
        int rows = userService.addUser(user);
        return rows > 0 ? "User berhasil ditambahkan" : "Gagal menambahkan user";
    }
}
