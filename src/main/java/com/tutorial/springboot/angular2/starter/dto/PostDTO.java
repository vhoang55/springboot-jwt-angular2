package com.tutorial.springboot.angular2.starter.dto;

import java.io.Serializable;

public class PostDTO implements Serializable {
    private Long id;
    private String title;
    private String subtitle;
    private String content;
    private String date;
    private String author;

    public PostDTO() {}

    public PostDTO(Long id, String title, String subtitle, String content, String date, String author) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.content = content;
        this.date = date;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
