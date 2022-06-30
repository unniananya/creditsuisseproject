package com.example.creditSuisseProject.repository;

import com.example.creditSuisseProject.model.Post;
import com.example.creditSuisseProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "select * from creditsuisse.post u where u.user_id=:id" , nativeQuery = true)
    public List<Post> findByUserPost(@Param("id") long id);
}
