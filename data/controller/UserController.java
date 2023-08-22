package com.trungphap.backend.controller;


import lombok.AllArgsConstructor;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.trungphap.backend.entity.User;
import com.trungphap.backend.service.UserService;
import java.util.List;



@RestController
@AllArgsConstructor
@RequestMapping("api/user")
@CrossOrigin(origins = {"http://localhost:3000" ,"http://localhost:3001"} , exposedHeaders ="Content-Range")

public class UserController {
       private UserService userService;

    @PostMapping
      public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

    }
     @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId) {
        User User = userService.getUserById(userId);
        return new ResponseEntity<>(User, HttpStatus.OK);
    }
     @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Range","item 0-" + users.size()+ "/" + users.size());
        return ResponseEntity.ok().headers(headers).body(users);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long UserId, @RequestBody User User) {
        User.setId(UserId);
        User updatedUser = userService.updateUser(User);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long UserId) {
        userService.deleteUser(UserId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
}
