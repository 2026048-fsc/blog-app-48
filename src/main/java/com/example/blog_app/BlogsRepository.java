package com.example.blog_app;

import java.util.List;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class BlogsRepository {
    private final JdbcClient jdbcClient;

    public BlogsRepository(JdbcClient jdbcClient){
        this.jdbcClient=jdbcClient;
    }
    public List<Blog> findAll(){
        return jdbcClient.sql("SELECT  FROM WHERE)
        .quary()
        .list();
    }
}
