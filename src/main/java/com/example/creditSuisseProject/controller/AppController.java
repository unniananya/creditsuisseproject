package com.example.creditSuisseProject.controller;

import com.example.creditSuisseProject.model.Post;
import com.example.creditSuisseProject.model.Role;
import com.example.creditSuisseProject.model.User;
import com.example.creditSuisseProject.service.PostService;
import com.example.creditSuisseProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private UserService service;

    @Autowired
    private PostService postService;

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        List<Role> listRoles = service.listRoles();
        model.addAttribute("user", new User());
        model.addAttribute("listRoles", listRoles);
        return "signup_form";
    }

    @GetMapping("/mentee_home")
    public String viewMenteeHomePage() {
        return "mentee_home";
    }

    @GetMapping("/mentor_home")
    public String viewMentorHomePage() {
        return "mentor_home";
    }

    @PostMapping("/process_register") //("/process_register")
    public String processRegister(User user) {
        service.registerDefaultUser(user);

        return "register_success";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = service.listAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }

    @GetMapping("/addPost")
    public String showAddPost(Model model)
    {
        model.addAttribute("post", new Post());
        return "addPost";
    }

//    @PostMapping("/addP")
//    public String savePost(@RequestParam("file") MultipartFile file,
//                           @RequestParam("desc") String desc)
//    {
//        postService.savePostToDB(file, desc);
//        return "post_success";
//    }

    @PostMapping("/addP")
    public String savePost(Post post) {
        postService.registerPost(post);
        return "post_success";
    }

    @GetMapping("/chatroom")
    public String viewChatPage() {

        return "chat-app";
    }

    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        User user = service.get(id);
        List<Role> listRoles = service.listRoles();
        model.addAttribute("user", user);
        model.addAttribute("listRoles", listRoles);
        return "user_form";
    }

    @PostMapping("/users/save")
    public String saveUser(User user) {
        service.save(user);

        return "redirect:/users";
    }
}

