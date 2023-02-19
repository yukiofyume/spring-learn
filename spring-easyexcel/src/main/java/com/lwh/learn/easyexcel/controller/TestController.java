package com.lwh.learn.easyexcel.controller;

import com.alibaba.excel.EasyExcel;
import com.lwh.learn.easyexcel.entity.DutyPersonEntity;
import com.lwh.learn.easyexcel.listener.DutyPersonListener;
import com.lwh.learn.easyexcel.repository.DutyPersonRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author lwh
 * @date 2023-02-18 21:07:28
 * @describe TODO
 */
@Tag(name = "excel测试")
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    private DutyPersonRepository dutyPersonRepository;

    @Operation(summary = "下载值班人员模板")
    @GetMapping("/download")
    public void download(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("测试", StandardCharsets.UTF_8).replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), DutyPersonEntity.class).sheet("模板").doWrite(() -> null);
        log.info("成功下载了模板");
    }

    @Operation(summary = "导入值班人员数据")
    @PostMapping("upload")
    @ResponseBody
    public String upload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), DutyPersonEntity.class, new DutyPersonListener(dutyPersonRepository)).sheet().doRead();
        log.info("读取数据成功");
        return "success";
    }
}
