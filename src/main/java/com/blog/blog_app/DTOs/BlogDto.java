package com.blog.blog_app.DTOs;
import com.blog.blog_app.Enums.BlogType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BlogDto {

    private int userId ;
    private String title ;
    private String content ;
    private BlogType blogType ;

}
