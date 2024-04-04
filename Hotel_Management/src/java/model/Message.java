package model;

import java.util.Date;

public class Message {
    
    private int id;
    private int conversationId;
    private String message;
    private int createdBy;
    private Date createdAt;

    public Message() {
    }

    public Message(int id, int conversationId, String message, int createdBy, Date createdAt) {
        this.id = id;
        this.conversationId = conversationId;
        this.message = message;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConversationId() {
        return conversationId;
    }

    public void setConversationId(int conversationId) {
        this.conversationId = conversationId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
}
