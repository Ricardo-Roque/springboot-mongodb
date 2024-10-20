package org.example.springbootmongodb.services;

import org.example.springbootmongodb.entities.Post;
import org.example.springbootmongodb.repository.PostRepository;
import org.example.springbootmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(String id) {
        Post post = postRepository.findById(id).orElse(null);
        if (post == null) {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return post;
    }
}