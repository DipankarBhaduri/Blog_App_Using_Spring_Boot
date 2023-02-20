package com.blog.blog_app.Services;
import com.blog.blog_app.Models.User;
import com.blog.blog_app.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository ;

    // Sign Up Request API
    public String signup ( User user){
        String userName = user.getEmail();
        int n = userName.length();
        char count = 0 ;
        for ( int i = 0 ; i < n ; i++ ){
            char ch = userName.charAt(i) ;
            if ( ch == '@'){
                count++ ;
            }
        }

        if ( count != 1 ){
            return "Enter a valid email id" ;
        }

        String password = user.getPassword() ;
        int len = password.length();
        if ( len < 8 ){
            return "Please enter at least 8 character password" ;
        }
        int capitalCount = 0 ;
        int digitCount = 0 ;
        int smallCount = 0 ;
        int specialCharacterCount = 0 ;

        for ( int i = 0 ; i < len ; i++ ){
            char ch = password.charAt(i) ;
            if ( ch >= '0' && ch <= '9'){
                digitCount++ ;
            } else if ( ch >= 'a' && ch <= 'z'){
                smallCount++ ;
            } else if ( ch >= 'A' && ch <= 'Z'){
                capitalCount++ ;
            } else {
                specialCharacterCount++ ;
            }
        }

        if ( smallCount > 0 && capitalCount > 0 && specialCharacterCount > 0 && digitCount > 0 ){
            userRepository.save(user) ;
            return "Sign up successfully" ;
        } else {
            return "Your password should contain at least One capital , small , digit & Special character" ;
        }
    }

    // Log in Request API
    public String logIn ( User user ){
        String userName = user.getEmail() ;
        User fromDB = null ;
        try {
            fromDB = userRepository.findUserByEmail ( userName) ;
        } catch ( Exception s ){
            return s.getMessage().toString() ;
        }
        if ( user.getPassword().equals(fromDB.getPassword())){
            return "Login Successful & Contribute a blog" ;
        } else {
            return "incorrect password" ;
        }
    }

    // Delete user
    public String deleteById ( int id ){
        userRepository.deleteById(id);
        return "Deleted" ;
    }
}
