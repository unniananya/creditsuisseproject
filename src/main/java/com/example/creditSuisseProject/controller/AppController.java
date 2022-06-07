package com.example.creditSuisseProject.controller;

import java.io.IOException;
import java.util.List;

import com.example.creditSuisseProject.model.CustomUserDetails;
import com.example.creditSuisseProject.model.Post;
import com.example.creditSuisseProject.model.Role;
import com.example.creditSuisseProject.model.User;
import com.example.creditSuisseProject.service.PostService;
import com.example.creditSuisseProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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

    @GetMapping("/users/mentee_home")
    public String viewMenteeHomePage() {
        return "mentee_home";
    }

    @GetMapping("/users/mentor_home")
    public String viewMentorHomePage() {
        return "mentor_home";
    }

    @PostMapping("/process_register") //("/process_register")
    public String processRegister(User user) {
        service.registerDefaultUser(user);

        return "register_success";
    }

    @GetMapping("/users/account")
    public String viewDetails(@AuthenticationPrincipal CustomUserDetails loggedUser,
                              Model model) {

        List<Role> listRoles = service.listRoles();
        String email = loggedUser.getUsername();
        User user = service.getByEmail(email);
        model.addAttribute("user", user);
        model.addAttribute("listRoles", listRoles);
        return "account_form";

    }

    @PostMapping("/users/account/update")
    public String saveDetails(User user, @AuthenticationPrincipal CustomUserDetails loggedUser){


/*        loggedUser.setFirstName(user.getFirstName());
        loggedUser.setLastName(user.getLastName());
//        loggedUser.setIndustry(user.getIndustry());
        loggedUser.setInterest(user.getInterest());
        loggedUser.setOrganisation(user.getOrganisation());*/
        service.save1(user);

        return "account_success";
    }

    @GetMapping("/users/addPost")
    public String showAddPost(Model model)
    {
        model.addAttribute("post", new Post());
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        ((UserDetails)principal).se

        return "addPost";
    }

//    @PostMapping("/addP")
//    public String savePost(@RequestParam("file") MultipartFile file,
//                           @RequestParam("desc") String desc)
//    {
//        postService.savePostToDB(file, desc);
//        return "post_success";
//    }

//    @PostMapping("/users/addP")
//    public String savePost(Post post) {
//        postService.registerPost(post);
////        user.setPost(post);
//        return "post_success";
//    }



    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = service.listAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }

    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        User user = service.get(id);
        List<Role> listRoles = service.listRoles();
        model.addAttribute("user", user);
        model.addAttribute("listRoles", listRoles);
        return "user_form";
    }

    @GetMapping("/users/chatroom")
    public String viewChatPage(){

        return "chat-app";
    }

    @PostMapping("/users/save")
    public String saveUser(User user) {
        service.save(user);

        return "redirect:/users";
    }
}

