package com.jishiniao.jms1.controller;

import com.jishiniao.jms1.entity.User;
import com.jishiniao.jms1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User CreateUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping
    public int updateUser(@RequestBody Map<String, Object> requestBodyMap) {
        String email = (String) requestBodyMap.get("email");
        Long id = Long.parseLong((String) requestBodyMap.get("id"));
        return userService.updateUserByEmail(email, id);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

//    @GetMapping("/{email}")
//    public User getUserByEmail(@PathVariable String email) {
//        return userService.getUserByEmail(email);
//    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable String id) {
        return userService.getUserById( Long.parseLong(id));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        userService.deleteById(Long.parseLong(id));
    }

}
