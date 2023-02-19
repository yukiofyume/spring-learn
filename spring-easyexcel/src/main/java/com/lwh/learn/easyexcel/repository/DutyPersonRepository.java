package com.lwh.learn.easyexcel.repository;

import com.lwh.learn.easyexcel.entity.DutyPersonEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lwh
 * @date 2023-02-18 18:45:13
 * @describe TODO
 */
@Repository
public interface DutyPersonRepository {

    /**
     * 批量插入
     *
     * @param list
     * @return
     */
    long insertBatch(@Param("list") List<DutyPersonEntity> list);

    List<DutyPersonEntity> selectBatch();
}
