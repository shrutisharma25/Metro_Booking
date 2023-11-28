package com.booking.metro.Entity;

//User.java
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")

public class User {
    private String id;

    public User() {
        this.id = generateUserId();
    }

    public String getUserId() {
        return id;
    }

    private String generateUserId() {
        return "UID_" + java.util.UUID.randomUUID().toString();
    }
}

