package com.example.creditSuisseProject.controller;

import com.example.creditSuisseProject.model.Post;
import com.example.creditSuisseProject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/listPosts")
    public String showExampleView(Model model)
    {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "listPosts";
    }






    @GetMapping("/deletePost/{id}")
    public String deletePost(@PathVariable("id") Long id)
    {

        postService.deletePostById(id);
        return "redirect:/listPosts";
    }
}
