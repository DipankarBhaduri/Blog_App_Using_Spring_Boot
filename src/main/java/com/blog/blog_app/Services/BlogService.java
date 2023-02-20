package com.blog.blog_app.Services;
import com.blog.blog_app.DTOs.BlogDto;
import com.blog.blog_app.Models.Blog;
import com.blog.blog_app.Models.User;
import com.blog.blog_app.Repository.BlogRepository;
import com.blog.blog_app.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository ;

    @Autowired
    private UserRepository userRepository ;

    // Create Post :)
    public String createBlog (BlogDto blogDto){
        Blog blog = new Blog() ;
        blog.setTitle(blogDto.getTitle());
        blog.setContent(blogDto.getContent());
        blog.setBlogType(blogDto.getBlogType().toString());
        User user = userRepository.findById(blogDto.getUserId()).get() ;

        List< Blog > list = user.getBlogs() ;
        list.add(blog) ;

        blog.setUserDetails(user);

        // save parents , child automatically will be saved ;
        userRepository.save(user);
        return "Blog Posted" ;
    }


    // Delete Post :)
    public String deleteById ( int id){
        blogRepository.deleteById(id);
        return "Deleted" ;
    }
}
