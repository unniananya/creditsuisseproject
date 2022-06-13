package com.example.creditSuisseProject.repository;

import com.example.creditSuisseProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);


    @Query(value = "select * from creditsuisse.users u where u.username like %:keyword%" , nativeQuery = true)
    public List<User> findByUser(@Param("keyword") String keyword);

    @Query(value = "select * from creditsuisse.users u where u.industry like %:industry%" , nativeQuery = true)
    public List<User> findByIndustry(@Param("industry") String industry);
}
