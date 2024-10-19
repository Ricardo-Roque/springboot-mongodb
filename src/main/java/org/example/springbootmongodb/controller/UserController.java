package org.example.springbootmongodb.controller;

import org.example.springbootmongodb.dto.UserDTO;
import org.example.springbootmongodb.entities.User;
import org.example.springbootmongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/findAll")
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = userService.findAll();
        List<UserDTO> listDTO = list.stream().map(user -> new UserDTO(user.getId(), user.getName(), user.getEmail())).collect(Collectors.toList());
        return ResponseEntity.ok(listDTO);
    }
}
