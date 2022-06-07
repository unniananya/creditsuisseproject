package com.example.creditSuisseProject.model;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(nullable = false, length = 64)
    private String password;

    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    @Column(nullable = false, unique = true, length = 45)
    private String username;

    @Column(name = "organisation", nullable = false, length = 20)
    private String organisation;

//    @Column(name = "age")
//    private Integer age;


    @Column(name = "industry")
    private String industry;

    @Column(name = "interest")
    private String interest;

    @Column(name = "no_of_years_exp")
    private Integer noOfYearsExp;

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public Integer getNoOfYearsExp() {
        return noOfYearsExp;
    }

    public void setNoOfYearsExp(Integer noOfYearsExp) {
        this.noOfYearsExp = noOfYearsExp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "users_posts",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "post_id")
//    )
//    private Set<Post> posts = new HashSet<>();
//
//    public void setPost(Post post){
//        Set<Post> postList = this.getPosts();
//        postList.add(post);
//        this.setPosts(postList);
//    }
//
//    public Set<Post> getPosts() {
//        return posts;
//    }
//
//    public void setPosts(Set<Post> posts) {
//        this.posts = posts;
//    }

    //    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
//    private List<Post> postList = new ArrayList<>();
//
//    public List<Post> getPostList() {
//        return postList;
//    }
//
//    public void setPostList(List<Post> postList) {
//        this.postList = postList;
//    }

//    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER,
//            cascade = CascadeType.ALL)
//    private Set<Post> postSet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public boolean hasRole(String roleName) {
        Iterator<Role> iterator = this.roles.iterator();
        while (iterator.hasNext()) {
            Role role = iterator.next();
            if (role.getName().equals(roleName)) {
                return true;
            }
        }

        return false;
    }



}

