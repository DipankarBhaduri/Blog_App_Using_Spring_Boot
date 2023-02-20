package com.blog.blog_app.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table ( name = "command")
public class Command {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int id ;

    private String content ;

    @ManyToOne
    @JoinColumn
    private Blog blog_1 ;

    @ManyToOne
    @JoinColumn
    private User user_1 ;
}
