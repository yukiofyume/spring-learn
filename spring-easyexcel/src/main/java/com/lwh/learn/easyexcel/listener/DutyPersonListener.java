package com.lwh.learn.easyexcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.lwh.learn.easyexcel.entity.DutyPersonEntity;
import com.lwh.learn.easyexcel.repository.DutyPersonRepository;
import com.lwh.learn.utils.JacksonUtils;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author lwh
 * @date 2023-02-18 18:40:12
 * @describe 不能被Spring管理
 */
@Slf4j
public class DutyPersonListener implements ReadListener<DutyPersonEntity> {
    /**
     * 每隔5条存储数据库，实际使用中可以100条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 5;
    /**
     * 缓存的数据
     */
    private List<DutyPersonEntity> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

    private DutyPersonRepository dutyPersonRepository;

    public DutyPersonListener(DutyPersonRepository dutyPersonRepository) {
        this.dutyPersonRepository = dutyPersonRepository;
    }

    /**
     * 每来一条数据都会调用
     *
     * @param dutyPersonEntity one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param analysisContext  analysis context
     */
    @Override
    public void invoke(DutyPersonEntity dutyPersonEntity, AnalysisContext analysisContext) {
        log.info("解析到一条数据:{}", JacksonUtils.entity2Json(dutyPersonEntity));
        cachedDataList.add(dutyPersonEntity);
        if (cachedDataList.size() >= BATCH_COUNT) {
            saveData();
            //存储完成后清理 list
            cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }
    }

    /**
     * 所以数据解析完成了，都会来调用
     *
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // 这里的 save 操作是插入不足 BATCH_COUNT 的数据
        saveData();
        log.info("所以数据解析完成");
    }

    private void saveData() {
        log.info("{}条数据，开始存储数据库！", cachedDataList.size());
        cachedDataList.forEach(dutyPersonEntity -> {
            dutyPersonEntity.setDeleteFlag(0);
            dutyPersonEntity.setCreateTime(LocalDateTime.now());
            dutyPersonEntity.setUpdateTime(LocalDateTime.now());
        });
        dutyPersonRepository.insertBatch(cachedDataList);
        log.info("存储数据库成功！");
    }
}
