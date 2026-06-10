package com.example.blog_app;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class BlogService {
    private BlogsRepository blogsRepository;

    public BlogService(BlogsRepository blogsRepository){
        this.blogsRepository=blogsRepository;
    }
    public List<Blog>findAll(){
      return blogsRepository.findAll();
    }
    public void add(blogform form){
        if (form.getName()==null||form.getTitle()==null||form.getText()==null) {
            throw new IllegalStateException();   
        }
        blogsRepository.save(new Blog(null, form.getName(), form.getTitle(), form.getText()));
    }
    public Optional<Blog> findById(Long id){
        return blogsRepository.findById(id);
    }

}
