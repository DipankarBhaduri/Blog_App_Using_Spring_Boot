package com.blog.blog_app.Repository;
import com.blog.blog_app.Models.Command;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandRepository extends JpaRepository <Command , Integer > {

}
