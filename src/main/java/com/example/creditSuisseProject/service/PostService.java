package com.example.creditSuisseProject.service;

import com.example.creditSuisseProject.model.Post;
import com.example.creditSuisseProject.model.Role;
import com.example.creditSuisseProject.model.User;
import com.example.creditSuisseProject.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

//    public void  savePostToDB(MultipartFile file,String description)
//    {
//        Post p = new Post();
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//        if(fileName.contains(".."))
//        {
//            System.out.println("not a a valid file");
//        }
//        try {
//            p.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        p.setDescription(description);
//
//
//
//        postRepository.save(p);
//    }

    public Post save(Post post) {

        return postRepository.save(post);
    }

    public void registerPost(Post post){
//        String image = post.getImage();
//        String newimage=Base64.getEncoder().encodeToString(image.getBytes());
//        post.setImage(newimage);
//        MultipartFile file=post.getFile();
//        post.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        postRepository.save(post);
    }
    public List<Post> getAllPosts()
    {
        return postRepository.findAll();
    }
    public void deletePostById(long id)
    {
        postRepository.deleteById(id);
    }

}
