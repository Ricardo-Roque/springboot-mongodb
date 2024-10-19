package org.example.springbootmongodb.services;

import org.example.springbootmongodb.dto.UserRequestDTO;
import org.example.springbootmongodb.entities.User;
import org.example.springbootmongodb.repository.UserRepository;
import org.example.springbootmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return user;
    }

    public User save(UserRequestDTO userRequestDTO) {
        User user = new User(userRequestDTO.id(), userRequestDTO.name(), userRequestDTO.email());
        return user;
    }
}
