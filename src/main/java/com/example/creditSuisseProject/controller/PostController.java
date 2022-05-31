package com.example.creditSuisseProject.controller;

import com.example.creditSuisseProject.model.Post;
import com.example.creditSuisseProject.repository.PostRepository;
import com.example.creditSuisseProject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository repo;

    @GetMapping("/users/listPosts")
    public String showExampleView(Model model)
    {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "listPosts";
    }

    @PostMapping("/users/addP")
    public String savePost(@ModelAttribute(name="post") Post post, @RequestParam("fileImage") MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        post.setImage(fileName);

        Post savedPost = postService.save(post);

        String uploadDir = "./src/main/resources/static/post-images/" + savedPost.getId();

        Path uploadPath = Paths.get(uploadDir);

        if(!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath,StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e){
            throw new IOException("Could not save new uploaded file: " + fileName);
        }

//        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

        return "post_success";
    }






    @GetMapping("users/deletePost/{id}")
    public String deletePost(@PathVariable("id") Long id)
    {

        postService.deletePostById(id);
        return "redirect:/listPosts";
    }
}
