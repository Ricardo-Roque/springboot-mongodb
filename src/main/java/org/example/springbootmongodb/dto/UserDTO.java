package org.example.springbootmongodb.dto;

public record UserDTO(
        String id,
        String name,
        String email
) {
}
