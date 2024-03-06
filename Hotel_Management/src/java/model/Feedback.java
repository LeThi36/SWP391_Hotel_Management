/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.UserDAO;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Feedback {
    private int userId;
    private int roomId;
    private int rating;
    private String content;
    private Date createdDate;

    public Feedback() {
    }

    public Feedback(int userId, int roomId, int rating, String content, Date createdDate) {
        this.userId = userId;
        this.roomId = roomId;
        this.rating = rating;
        this.content = content;
        this.createdDate = createdDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
    public User getUserFeedback() {
        return new UserDAO().readUserById(userId);
    }

    @Override
    public String toString() {
        return "Feedback{" + "userId=" + userId + ", roomId=" + roomId + ", rating=" + rating + ", content=" + content + ", createdDate=" + createdDate + '}';
    }
     
    
}
