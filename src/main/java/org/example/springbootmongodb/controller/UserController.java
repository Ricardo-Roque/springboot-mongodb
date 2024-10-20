package org.example.springbootmongodb.controller;

import org.example.springbootmongodb.dto.UserDTO;
import org.example.springbootmongodb.dto.UserRequestDTO;
import org.example.springbootmongodb.entities.Post;
import org.example.springbootmongodb.entities.User;
import org.example.springbootmongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping("/findById/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User user = userService.findById(id);
        UserDTO userDTO = new UserDTO(user.getId(), user.getName(), user.getEmail());
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody UserRequestDTO userRequestDTO) {
        User user = userService.save(userRequestDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@RequestBody UserRequestDTO userRequestDTO, @PathVariable String id) {

        User newUser = new User(id, userRequestDTO.name(), userRequestDTO.email());
        userService.update(newUser);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(user.getPosts());
    }
}
