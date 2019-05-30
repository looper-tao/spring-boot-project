package com.boot.learn.service.easyexcell;

import com.boot.learn.service.easyexcel.EasyExcelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @Author: taozhengzhi
 * @Date: 2019/5/30 下午6:30
 * @Version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class EasyExcellServiceTest {
    
    @Autowired
    private EasyExcelService easyExcelService;
    
    @Test
    public void writeTest(){
        try {
            easyExcelService.writeExcel();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
