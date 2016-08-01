package com.tutorial.springboot.angular2.starter.controllers;


import com.tutorial.springboot.angular2.starter.dto.PostDTO;
import com.tutorial.springboot.angular2.starter.model.Post;
import com.tutorial.springboot.angular2.starter.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllPosts() {
        List<Post> allPosts =  postService.findAll();
        return new ResponseEntity<>(allPosts, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Post post = postService.findOnePostById(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> addNewPost(@RequestBody PostDTO postDTO) {
        Post post = toPost(postDTO);
        postService.save(post);
        return new ResponseEntity<>(postDTO.getTitle(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePostById( @PathVariable Long id) {
        postService.deletePostById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    private Post toPost(PostDTO postDTO) {
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setSubtitle(postDTO.getSubtitle());
        post.setContent(postDTO.getContent());
        post.setDate(LocalDate.now().toString());
        post.setAuthor(postDTO.getAuthor());
        return post;
    }



}
