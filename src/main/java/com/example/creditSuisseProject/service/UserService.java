package com.example.creditSuisseProject.service;

import com.example.creditSuisseProject.model.Role;
import com.example.creditSuisseProject.model.User;
import com.example.creditSuisseProject.repository.RoleRepository;
import com.example.creditSuisseProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    RoleRepository roleRepo;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepo;

    public void registerDefaultUser(User user) {
        Role roleUser = roleRepo.findByName("User");
        user.addRole(roleUser);
        encodePassword(user);
        userRepo.save(user);
    }

    public List<User> listAll() {
        return userRepo.findAll();
    }

    public User get(Long id) {
        return userRepo.findById(id).get();
    }

    public List<Role> listRoles() {
        return roleRepo.findAll();
    }


    public List<User> findByUser(String keyword){
        if (keyword != null){
            return userRepo.findByUser(keyword);
        }
        return userRepo.findAll();

    }

    public List<User> findByIndustryandInterest(String interest, String industry) {
        if (industry != null && interest !=null) {
            return userRepo.findByInterestandIndustry(interest, industry);
        }
        else if (industry != null && interest ==null){
            return userRepo.findByIndustry(industry);
        }
        else if (industry == null && interest !=null){
            return userRepo.findByInterest(interest);
        }
        return userRepo.findAll();
    }

    public void save(User user) {
        encodePassword(user);
        userRepo.save(user);
    }

    public void save1(User user) {
        userRepo.save(user);
    }

    public User getByEmail(String email) {
        return userRepo.findByEmail(email);
    }
    private void encodePassword(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    }
}
