package com.lwh.learn.security;

import com.lwh.learn.security.model.entity.Role;
import com.lwh.learn.security.model.entity.User;
import com.lwh.learn.security.repository.UserRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lwh
 * @date 2023-11-09 22:30:49
 * @describe --
 */
@SpringBootTest
class SecurityDemoApplicationTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void contextLoads() {
        User u1 = new User();
        u1.setUsername("javaboy");
        u1.setPassword("123");
        u1.setAccountNonExpired(true);
        u1.setAccountNonLocked(true);
        u1.setCredentialsNonExpired(true);
        u1.setEnabled(true);
        List<Role> rs1 = new ArrayList<>();
        Role r1 = new Role();
        r1.setName("ROLE_admin");
        r1.setNameZh("管理员");
        rs1.add(r1);
        u1.setRoles(rs1);
        userRepository.save(u1);
        User u2 = new User();
        u2.setUsername("江南一点雨");
        u2.setPassword("123");
        u2.setAccountNonExpired(true);
        u2.setAccountNonLocked(true);
        u2.setCredentialsNonExpired(true);
        u2.setEnabled(true);
        List<Role> rs2 = new ArrayList<>();
        Role r2 = new Role();
        r2.setName("ROLE_user");
        r2.setNameZh("普通用户");
        rs2.add(r2);
        u2.setRoles(rs2);
        userRepository.save(u2);
    }


    public static void main(String[] args) {
        String s ="cWVzZU0yT2lPNlo3Y2l2cGRrR1dUUSUzRCUzRDp5S3hqVEFpS1JBJTJCZGUzTlcxeUFjR1ElM0QlM0Q";
        String s1 = new String(Base64.decodeBase64(s));
        System.out.println(s1);
    }
}