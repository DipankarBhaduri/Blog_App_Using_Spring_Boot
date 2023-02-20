package com.blog.blog_app.Controller;
import com.blog.blog_app.DTOs.BlogDto;
import com.blog.blog_app.Services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService ;

    @PostMapping ("/post")
    public String newBlog (@RequestBody BlogDto blogDto ){
        return blogService.createBlog(blogDto) ;
    }

    @DeleteMapping ("/delete/{id}")
    public String deleteBlog ( @PathVariable("id") int id){
        return blogService.deleteById(id) ;
    }
}
