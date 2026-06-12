package com.example.blog_app;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class BlogController {

    private final BlogService blogService;
    public BlogController(BlogService blogService){
        this.blogService=blogService;
    }

    @GetMapping("/")//メインページに返す
    public String blog() {
        return "redirect:/blogs";//redirectで/blogsのGetMappingに送ることで一覧画面になる
    }
    
    @GetMapping("/blogs")
    public String blogs(Model model) {
        model.addAttribute("blog", blogService.findAll());/** */
        return "blogs";
    }
    @GetMapping("/blogs/new")
    public String newpost() {
        return "blogs/new";
    }
    @GetMapping("/blogs/profile")
    public String profile() {
        return "blogs/profile";
    }
    
    
    @PostMapping("/blogs")
    public String createblog(blogform form) {
        //TODO: process POST request
        // Blog blog = new Blog(form.getName(), form.getTitle(), form.getText());
        blogService.add(form);
        
        return "redirect:/blogs";///blogsにGETリクエストを送って
    }
    
    @GetMapping("/blogs/{id}")
    public String getMethodName(@PathVariable Long id,Model model) {
        Optional<Blog> blogOpt = blogService.findById(id);
        if (blogOpt.isEmpty()) {
            return "redirect:/blogs";
        }
        model.addAttribute("blog", blogOpt.get());
        return "blogs/detail";
    }
    
}
