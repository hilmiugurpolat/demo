package com.hilmiUgurPolat.repository;

import com.hilmiUgurPolat.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<Auth,Long>{
    Boolean existsByUserNameAndPassword(String userName, String password);
}
