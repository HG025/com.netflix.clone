package com.netflix.clone.com.netflix.clone.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.netflix.clone.com.netflix.clone.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

  Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    Optional<User> findByVerificationToken(String verificationToken);

     Optional<User> findByPasswordResetToken(String passwordResetToken);


}
