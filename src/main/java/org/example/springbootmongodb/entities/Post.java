package org.example.springbootmongodb.entities;

import org.example.springbootmongodb.dto.AuthorDTO;
import org.example.springbootmongodb.dto.CommentDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Document
public class Post implements Serializable {

    @Id
    private String id;
    private Date date;
    private String title;
    private String body;
    private AuthorDTO authorDTO;
    private List<CommentDTO> comments = new ArrayList<>();

    public Post() {
    }

    public Post(String id, Date date, String title, String body, AuthorDTO authorDTO) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.authorDTO = authorDTO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public AuthorDTO getAuthorDTO() {
        return authorDTO;
    }

    public void setAuthorDTO(AuthorDTO authorDTODTO) {
        this.authorDTO = authorDTODTO;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Post post = (Post) object;
        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
