package com.blog.blog_app.Repository;
import com.blog.blog_app.Models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository <Blog, Integer > {
    @Query ( value = "select * from blog where title=:blogTitle" , nativeQuery = true)
    Blog  findByBlogTitle ( String blogTitle) ;

}
