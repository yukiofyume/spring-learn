package com.lwh.learn;

import com.lwh.learn.multidb.entity.product.ProductEntity;
import com.lwh.learn.multidb.entity.user.UserEntity;
import com.lwh.learn.multidb.repository.product.ProductRepository;
import com.lwh.learn.multidb.repository.user.UserRepository;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//@DataJpaTest
@Slf4j
@SpringBootTest
class JpaApplicationTest {

    @Resource
    private UserRepository userRepository;
    @Resource
    private ProductRepository productRepository;

    /**
     * todo
     * 批量插入的时候，自增id会重复
     */
    @Test
    @Rollback(value = false)
    @Transactional(value = "userTransactionManager")
    void userInsert() {
        var userEntities = new ArrayList<UserEntity>();
        userEntities.add(new UserEntity("lwh", "121", 24));
        userEntities.add(new UserEntity("hwl", "121", 24));
        List<UserEntity> userEntities1 = userRepository.saveAllAndFlush(userEntities);
        log.info("size:{}", userEntities1.size());
    }

    @Test
    @Rollback(value = false)
    @Transactional(value = "productTransactionManager")
    void productInsert() {
        var productEntities = new ArrayList<ProductEntity>();
        productEntities.add(new ProductEntity("lwh", 12.00));
        productEntities.add(new ProductEntity("hwl", 3.00));
        List<ProductEntity> productEntities1 = productRepository.saveAllAndFlush(productEntities);
        log.info("size:{}", productEntities1.size());
    }
}