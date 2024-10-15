package org.example.springbootmongodb.controller;

import org.example.springbootmongodb.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/findAll")
    public ResponseEntity<List<User>> findAll() {
        User user = new User(null, "Ricardo Roque", "ricardo@gmail.com");
        User user2 = new User(null, "Alex Green", "alex@gmail.com");

        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(user, user2));

        return ResponseEntity.ok(list);
    }
}
