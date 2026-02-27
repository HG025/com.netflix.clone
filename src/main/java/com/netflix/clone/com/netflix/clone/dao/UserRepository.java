package com.netflix.clone.com.netflix.clone.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.netflix.clone.com.netflix.clone.entity.User;
import com.netflix.clone.com.netflix.clone.enums.Role;

public interface UserRepository extends JpaRepository<User, Long>{

  Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    Optional<User> findByVerificationToken(String verificationToken);

     Optional<User> findByPasswordResetToken(String passwordResetToken);

     long countByRoleAndActive(Role admin, boolean active);

     @Query("SELECT u FROM User u WHERE " +
      "LOWER(u.fullName) LIKE LOWER(CONCAT('%', :search,'%')) OR " +
      "LOWER(u.email) LIKE LOWER(CONCAT('%', :search,'%'))")
     Page<User> searchUser(@Param("search") String search, Pageable pageable);

     long countByRole(Role role);

}
