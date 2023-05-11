package com.lwh.learn.multidb.repository.user;

import com.lwh.learn.multidb.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author lwh
 * @version 1.0
 * @date 2023-05-11 15:20:07
 * @describe --
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {
}
