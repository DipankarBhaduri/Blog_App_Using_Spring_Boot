package com.blog.blog_app.Models;
import com.blog.blog_app.Enums.BlogType;
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
@Table ( name = "blog")
public class Blog {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int id ;

    private String title ;

    private String content ;

    private String blogType ;

    @ManyToOne
    @JoinColumn
    private User userDetails ;

    @OneToMany ( mappedBy = "blog_1" , cascade = CascadeType.ALL)
    List< Command > commands = new ArrayList<>() ;
}
