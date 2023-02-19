package com.lwh.learn.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.github.pagehelper.PageHelper;
import com.lwh.learn.easyexcel.entity.DutyPersonEntity;
import com.lwh.learn.easyexcel.listener.DutyPersonListener;
import com.lwh.learn.easyexcel.repository.DutyPersonRepository;
import com.lwh.learn.utils.JacksonUtils;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@Slf4j
@SpringBootTest
class EasyExcelApplicationTest {
    @Resource
    private DutyPersonRepository dutyPersonRepository;

    @Test
    void localDateTimeTest() {
        DutyPersonEntity dutyPersonEntity = new DutyPersonEntity();
        LocalDateTime now = LocalDateTime.now();
        dutyPersonEntity.setDutyTime(now);
        log.info("now:{}", now);
        log.info("json:{}", JacksonUtils.entity2Json(dutyPersonEntity));
    }

    @Test
    void simpleDownload() {
        String fileName = "D:\\Project\\JavaProject\\spring-learn\\spring-easyexcel\\src\\main\\resources\\值班人员模板.xlsx";
        EasyExcel.write(fileName, DutyPersonEntity.class)
                .sheet("测试")
                .doWrite(() -> null);
        log.info("成功导出模板Excel");
    }

    @Test
    void simpleRead() {
        String fileName = "D:\\Project\\JavaProject\\spring-learn\\spring-easyexcel\\src\\main\\resources\\值班人员模板.xlsx";
        EasyExcel.read(fileName, DutyPersonEntity.class, new DutyPersonListener(dutyPersonRepository)).sheet().doRead();
    }

    @Test
    void simpleWrite() {
        String fileName = "D:\\Project\\JavaProject\\spring-learn\\spring-easyexcel\\src\\main\\resources\\值班人员下载.xlsx";
        EasyExcel.write(fileName, DutyPersonEntity.class)
                .sheet("测试")
                .doWrite(() -> {
                    PageHelper.startPage(1, 10);
                    return dutyPersonRepository.selectBatch();
                });
    }
}