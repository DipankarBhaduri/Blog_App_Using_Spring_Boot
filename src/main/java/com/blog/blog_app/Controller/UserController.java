package com.blog.blog_app.Controller;
import com.blog.blog_app.Models.User;
import com.blog.blog_app.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping ("/user")
public class UserController {
    @Autowired
    UserService userService ;

    @PostMapping ("/signup")
    public String signup (@RequestBody User user ){
        return userService.signup(user) ;
    }

    @PostMapping ("/login")
    public String logIn ( @RequestBody User user ){
        return userService.logIn(user);
    }

    @DeleteMapping ( "/delete/{id}")
    public String deleteUser (@PathVariable("id") int id ){
        return userService.deleteById ( id ) ;
    }
}
