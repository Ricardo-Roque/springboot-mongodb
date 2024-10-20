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

    public User update(User user) {
        User newUser = userRepository.findById(user.getId()).orElse(null);
        updateData(newUser, user);
        return userRepository.save(newUser);
    }

    public void delete(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public void updateData(User newUser, User user) {
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }
}
