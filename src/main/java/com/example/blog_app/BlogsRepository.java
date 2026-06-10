package com.example.blog_app;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class BlogsRepository {
    private final JdbcClient jdbcClient;

    public BlogsRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Blog> findAll() {
        return jdbcClient.sql("SELECT id,name,title,text FROM blog ")
                .query(Blog.class)
                .list();

    }

    public void save(Blog blog) {
        jdbcClient.sql("INSERT INTO blog(name,title,text)VALUES(:name,:title,:text)")
                .param("name", blog.getName())
                .param("title", blog.getTitle())
                .param("text", blog.getText())
                .update();

    }public Optional<Blog> findById(Long id){
        return jdbcClient.sql("SELECT id,name,title,text FROM blog WHERE id = :id")
            .param("id",id)
            .query(Blog.class)
            .optional();
    }


}
