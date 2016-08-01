package com.tutorial.springboot.angular2.starter.repository;


import com.tutorial.springboot.angular2.starter.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query(value = "SELECT p FROM Post p WHERE p.id = ?1")
    Post findOnePostById(Long id);

    @Modifying
    @Query(value = "DELETE FROM Post p WHERE p.id = ?1")
    void delete(Long id);
}
