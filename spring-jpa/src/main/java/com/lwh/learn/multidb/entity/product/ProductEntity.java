package com.lwh.learn.multidb.entity.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-11 15:14:32
 * @describe --
 */
@Data
@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;

    public ProductEntity(String name, Double price) {
        this.name = name;
        this.price = price;
    }
}
