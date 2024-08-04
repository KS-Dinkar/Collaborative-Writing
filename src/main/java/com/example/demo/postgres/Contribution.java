package com.example.demo.postgres;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Contribution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "story_id",nullable = false)
    private Story story;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User author;

    @Column
    @Lob
    private String content;

    @OneToMany(mappedBy = "contribution")
    private List<Comments> comments;

    @Column(name = "contrib_upvotes")
    private int upvotes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Story getStory() {
        return story;
    }

    public void setStory(Story story) {
        this.story = story;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
