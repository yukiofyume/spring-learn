package com.lwh.learn;

import com.lwh.learn.repository.ArticleRepository;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

//@DataJpaTest
@SpringBootTest
class JpaApplicationTest {
    @Resource
    private ArticleRepository articleRepository;

    @Test
    void test1() {
        articleRepository.findAllByCreationDateTimeBefore(LocalDateTime.now()).forEach(System.out::println);
    }
}