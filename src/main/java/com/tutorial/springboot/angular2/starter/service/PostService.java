package com.tutorial.springboot.angular2.starter.service;


import com.tutorial.springboot.angular2.starter.model.Post;
import com.tutorial.springboot.angular2.starter.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface PostService {
    List<Post> findAll();
    Post findOnePostById(Long id);
    void save(Post post);
    void deletePostById(Long id);
}
