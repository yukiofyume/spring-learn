package com.lwh.learn.repository;

import com.lwh.learn.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author lwh
 * @date 2023-04-01 21:06:32
 * @describe TODO
 */
@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Long>, JpaSpecificationExecutor<ArticleEntity> {

    List<ArticleEntity> findAllByCreationDateTimeBetween(LocalDateTime startTime, LocalDateTime endTime);
    List<ArticleEntity> findAllByCreationDateTimeBefore(LocalDateTime time);
}
