package com.boot.learn.controller;

import com.boot.learn.service.excel.ExcelHandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Author: taozhengzhi
 * @Date: 2019/6/24 上午10:46
 * @Version 1.0
 */
@RestController
@RequestMapping("excel/handle")
public class ExcelHandleController {

    @Autowired
    private ExcelHandleService excelHandleService;
    
    @RequestMapping(value = "job",method = RequestMethod.POST)
    public void jobHandle(@RequestParam("file") MultipartFile jobFile) throws IOException {
        
        excelHandleService.parseJob(jobFile);
    }
}
