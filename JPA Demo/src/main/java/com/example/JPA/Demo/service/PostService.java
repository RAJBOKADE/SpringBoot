package com.example.JPA.Demo.service;

import com.example.JPA.Demo.model.Post;
import com.example.JPA.Demo.model.PostResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
@Log4j2
public class PostService {

    private final RestTemplate restTemplate;

    @Autowired
    public PostService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${test.url}")
    private String testUrl;
    public PostResponse createPost(Post post) {
        log.info("Entered post Method");

        HttpEntity<Post> http = new HttpEntity<>(post);
        ResponseEntity<PostResponse> postResponse = restTemplate.exchange(testUrl+"/posts", HttpMethod.POST, http, PostResponse.class);
        return postResponse.getBody();

    }

    public Post getPost(Long id) {
        Post post = restTemplate.getForObject(testUrl+"/posts/{id}", Post.class, id);
        return post;
    }

    public void deleteById(Long userId){
       /* HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Post> httpEntity = new HttpEntity<>(httpHeaders);
        restTemplate.exchange(testUrl +"/posts/{userId}", HttpMethod.DELETE, httpEntity, Post.class, userId);*/
        restTemplate.delete(testUrl+"/posts/{id}", Post.class, userId);

    }

    public  PostResponse updatePost(Long id, PostResponse postRespoonse) {
        HttpEntity http = new HttpEntity<>(postRespoonse);
        ResponseEntity<PostResponse> response = restTemplate.exchange(testUrl + "/posts/"+id, HttpMethod.PUT, http, PostResponse.class, id);
        return response.getBody();
    }

}
