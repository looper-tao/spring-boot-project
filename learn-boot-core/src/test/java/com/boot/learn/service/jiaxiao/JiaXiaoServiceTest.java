package com.boot.learn.service.jiaxiao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
public class JiaXiaoServiceTest {
    @Autowired
    private JiaXiaoService jiaXiaoService;
    
    @Test
    public void loginTest(){
        jiaXiaoService.login("","");
    }
    
    @Test
    public void getUserInfoTest(){
        jiaXiaoService.getUserInfo("vuhty43vyxveagavzmgs1vmb");
    }
    
   
}