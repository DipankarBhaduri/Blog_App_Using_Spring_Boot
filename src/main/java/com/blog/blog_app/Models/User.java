package com.blog.blog_app.Models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table ( name = "user")
public class User {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int id ;

    private String email ;

    private String password ;

    @OneToMany( mappedBy = "userDetails" , cascade = CascadeType.ALL)
    List< Blog > blogs = new ArrayList<>() ;

    @OneToMany ( mappedBy = "user_1" , cascade = CascadeType.ALL)
    List< Command> commands = new ArrayList<>() ;

}
