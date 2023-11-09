package com.lwh.learn.security.repository;

import com.lwh.learn.security.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author lwh
 * @date 2023-11-09 22:17:59
 * @describe --
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
