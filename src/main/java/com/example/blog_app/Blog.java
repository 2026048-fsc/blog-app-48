package com.example.blog_app;

import java.sql.Date;

import org.springframework.stereotype.Repository;

public class Blog {
    private Long id;
    private String name;
    private String title;
    private String text;

    public Blog(Long id, String name,String title, String text) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
