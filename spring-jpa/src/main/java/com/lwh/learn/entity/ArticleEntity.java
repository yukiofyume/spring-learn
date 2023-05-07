package com.lwh.learn.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author lwh
 * @date 2023-04-01 19:48:37
 * @describe TODO
 */
@Data
@Entity
@Table(name = "article")
public class ArticleEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 632390398840582220L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Temporal(TemporalType.DATE)
//    private LocalDateTime publicationDate;
//    @Temporal(TemporalType.TIME)
//    private LocalDateTime publicationTime;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime creationDateTime;
}
