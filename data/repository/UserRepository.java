package com.trungphap.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.trungphap.backend.entity.User;

public interface UserRepository extends JpaRepository<User , Long> {
    
}




