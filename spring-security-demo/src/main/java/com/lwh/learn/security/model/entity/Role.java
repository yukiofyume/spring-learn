package com.lwh.learn.security.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author lwh
 * @date 2023-11-09 22:08:54
 * @describe --
 */
@Data
@Entity
@Table(name = "t_role")
public class Role implements Serializable {

    @Serial
    private static final long serialVersionUID = 6816522856965328180L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String nameZh;
}
