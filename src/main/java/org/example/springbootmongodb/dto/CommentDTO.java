package org.example.springbootmongodb.dto;

import java.util.Date;

public record CommentDTO(
        String text,
        Date date,
        AuthorDTO authorDTO
) {
}
