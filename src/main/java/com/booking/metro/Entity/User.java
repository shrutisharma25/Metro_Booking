package com.booking.metro.Entity;

//User.java
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
 @Id
 private String id;

 // No need for username and password

 public String getId() {
     return id;
 }

 public void setId(String id) {
     this.id = id;
 }
}
