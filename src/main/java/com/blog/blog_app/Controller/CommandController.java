package com.blog.blog_app.Controller;
import com.blog.blog_app.DTOs.CommandDto;
import com.blog.blog_app.Services.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@RestController
@RequestMapping ("/command")
public class CommandController {

    @Autowired
    private CommandService commandService ;

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int id ;

    @PostMapping ("/add")
    public String addCommand (@RequestBody CommandDto commandDto){
        return commandService.addCommand(commandDto) ;
    }

    @DeleteMapping ("/delete/{id}")
    public String deleteCommand ( int id){
        return commandService.deleteCommand(id) ;
    }


}
