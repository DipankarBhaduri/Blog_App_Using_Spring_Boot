package com.blog.blog_app.Services;
import com.blog.blog_app.DTOs.CommandDto;
import com.blog.blog_app.Models.Blog;
import com.blog.blog_app.Models.Command;
import com.blog.blog_app.Models.User;
import com.blog.blog_app.Repository.BlogRepository;
import com.blog.blog_app.Repository.CommandRepository;
import com.blog.blog_app.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandService {

    @Autowired
    private CommandRepository commandRepository ;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BlogRepository blogRepository;

    public String addCommand (CommandDto commandDto ){

        //Set all attributes for command :)
        Command command = new Command() ;
        command.setContent(commandDto.getCommandContent());
        User user = userRepository.findUserByEmail(commandDto.getUserEmail());
        command.setUser_1(user);
        Blog blog = blogRepository.findByBlogTitle ( commandDto.getBlogTitle()) ;
        command.setBlog_1(blog);

        //Set Command to Parents Blog :)
        List< Command > commandList = blog.getCommands() ;
        commandList.add( command ) ;
        blog.setCommands(commandList);

        //Set Command to Parents User :)
        List< Command > commandList1 = user.getCommands() ;
        commandList1.add(command);
        user.setCommands(commandList1);

        // save command to command Repository :)
        commandRepository.save(command);
        return "Command Posted" ;
    }


    public String deleteCommand ( int id){
        commandRepository.deleteById(id);
        return "Command Deleted" ;
    }
}
