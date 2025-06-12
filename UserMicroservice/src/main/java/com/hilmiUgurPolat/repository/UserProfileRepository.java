package com.hilmiUgurPolat.repository;

import com.hilmiUgurPolat.document.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserProfileRepository extends MongoRepository<UserProfile,String> {
}
