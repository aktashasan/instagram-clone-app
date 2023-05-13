package com.example.instagram_clone.data;

public class PostItemData {
    private String userName;
    private String profileImage;
    private Integer likeCount;
    private Integer commentCount;
    private String description;
    private String postImage;


    public PostItemData(String userName, String profileImage, Integer likeCount, Integer commentCount, String description, String postImage) {
        this.userName = userName;
        this.profileImage = profileImage;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
        this.description = description;
        this.postImage = postImage;
    }

    public String getUserName() {
        return userName;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public String getDescription() {
        return description;
    }

    public String getPostImage() {
        return postImage;
    }
}
