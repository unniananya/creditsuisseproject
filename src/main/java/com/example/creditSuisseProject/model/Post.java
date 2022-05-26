package com.example.creditSuisseProject.model;

import javax.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;

//    @ManyToOne(fetch = FetchType.EAGER, optional = true, cascade = CascadeType.PERSIST)
//    @JoinTable(name = "user_post", joinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id", nullable = true),
//            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = true))
//    @JsonIgnoreProperties("postList")
//    private User user;

//    @ManyToOne(fetch = FetchType.EAGER, optional = false)
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;
//    private MultipartFile file;
    public Post() {
    }

//    public Post(long id, String description, String image, User user) {
//        this.id = id;
//        this.description = description;
//        this.image = image;
//        this.user = user;
//    }

    public Post(long id, String description, String image) {
        this.id = id;
        this.description = description;
        this.image = image;
    }

//    public Post(long id, String description, String image, MultipartFile file) {
//        this.id = id;
//        this.description = description;
//        this.image = image;
//        this.file = file;
//    }

//    public MultipartFile getFile() {
//        return file;
//    }
//
//    public void setFile(MultipartFile file) {
//        this.file = file;
//    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
