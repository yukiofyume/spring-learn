package com.lwh.learn.multidb.repository.product;

import com.lwh.learn.multidb.entity.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-11 15:21:10
 * @describe --
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>, JpaSpecificationExecutor<ProductEntity> {
}
