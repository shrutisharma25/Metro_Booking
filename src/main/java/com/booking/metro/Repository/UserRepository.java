package com.booking.metro.Repository;

//UserRepository.java
import org.springframework.data.mongodb.repository.MongoRepository;

import com.booking.metro.Entity.User;

public interface UserRepository extends MongoRepository<User, String> {
 User findByUsername(String username);
}

