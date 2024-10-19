package org.example.springbootmongodb.dto;

public record UserRequestDTO(
        String id,
        String name,
        String email
) {
}
