package com.example.blog_app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class BlogController {

    private final BlogsRepository blogsRepository;
    public BlogController(BlogsRepository blogsRepository){
        this.blogsRepository=blogsRepository;
    }

    @GetMapping("/blogs")
    public String blogs() {
        return "blogs";
    }
    @PostMapping("/blogs")
    public String blog(Model model) {
        //TODO: process POST request
        model.addAttribute("text", blogsRepository.findAll());
        
        return "blogs";
    }
    
    
}
