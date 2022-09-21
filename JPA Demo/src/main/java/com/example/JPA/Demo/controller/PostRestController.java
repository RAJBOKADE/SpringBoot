package com.example.JPA.Demo.controller;

import com.example.JPA.Demo.model.Post;
import com.example.JPA.Demo.model.PostResponse;
import com.example.JPA.Demo.service.PostService;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Log4j2
@RestController

public class PostRestController {
    @Autowired
    private PostService postService;


    @PostMapping(path = "/posts", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostResponse> createPost(@RequestBody Post post) {
        // RestTemplate restTemplate = postService.(post);
        PostResponse postResponse = postService.createPost(post);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    @GetMapping(path = "/posts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Post> getPost(@PathVariable Long id) {
        Post post = postService.getPost(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @DeleteMapping(path = "/posts/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteById(@PathVariable Long userId) {
        postService.deleteById(userId);
        log.info("successfully deleted");
        return ResponseEntity.ok().build();

    }
}
