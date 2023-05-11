package com.lwh.learn.multidb.entity.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-11 15:10:20
 * @describe --
 */
@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 3686247110195022756L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    private Integer age;

    public UserEntity(String name, String email, Integer age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
}
