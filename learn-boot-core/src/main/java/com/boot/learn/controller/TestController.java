package com.boot.learn.controller;

import com.boot.learn.entity.DataWarehouse;
import com.boot.learn.service.excel.ExcelHandleService;
import com.boot.learn.untils.KJsonUtils;
import jxl.Sheet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("boot/test")
public class TestController {
    @Autowired
    private ExcelHandleService excelHandleService;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String test() {
        return "SUCCESS";
    }
    
    @RequestMapping(value = "edu",method = RequestMethod.POST)
    public void edu(@RequestParam("file") MultipartFile jobFile) throws IOException {
        Sheet sheet = excelHandleService.checkExcel2Jxl(jobFile);
        Map<String,String> map = new HashMap<>();
        map.clear();
        
        for(int i = 1; i < 230; i++) {
            String json = sheet.getCell(0, i).getContents();
            DataWarehouse dataWarehouse = KJsonUtils.toObject(json,DataWarehouse.class);
            if(map.get(dataWarehouse.getMobile()) == null){
                
                log.info("insert into `nt_data_warehouse` (`capacha`,`city`,`create_at`,`grade`,`ip_address`,`mobile`,`name`,`product_id`,`question`,`result`,`ad_code`,`province`,`sex`," +
                    "`append_info`) " +
                    "values('{}','{}','2020-01-06 12:28:43','{}','{}','{}','{}','{}','{}','SUCCESS','{}','{}','{}','');"
                    ,dataWarehouse.getCapacha(), dataWarehouse.getCity(),dataWarehouse.getGrade(),dataWarehouse.getIpAddress(),dataWarehouse.getMobile(),dataWarehouse.getName(),
                    getProductId(dataWarehouse.getGrade()),dataWarehouse.getQuestion(),dataWarehouse.getAdCode(),dataWarehouse.getProvince(),dataWarehouse.getSex());
                map.put(dataWarehouse.getMobile(),dataWarehouse.getMobile());
            }
        }
    }
    
    private int getProductId(DataWarehouse.Grade grade){
        switch(grade){
            case ADULT:
                return 5;
            case FIRST_GRADE_H:
                return 1;
            case SECOND_GRADE_H:
                return 1;
            case THIRD_GRADE_H:
                return 1;
            case LOW_CLASS_K:
                return 2;
            case MIDDLE_CLASS_K:
                return 2;
            case HIGH_CLASS_K:
                return 2;
            default:
                return 0;
        }
    }
}
