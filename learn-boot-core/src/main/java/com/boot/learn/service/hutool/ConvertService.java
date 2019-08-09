package com.boot.learn.service.hutool;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ReflectUtil;
import com.boot.learn.service.StudentService;

import java.io.File;
import java.lang.reflect.Method;

/**
 * @Author: taozhengzhi
 * @Date: 2019/8/7 下午3:51
 * @Version 1.0
 */
public class ConvertService {
    /**
     * 转字符串
     */
    public static void toStr(int number){
        String toStr = Convert.toStr(number);
        System.out.println(toStr);
        File[] ls = FileUtil.ls("/Users/yeguxin");
    
        Method[] methods = ReflectUtil.getMethods(StudentService.class);
        System.out.println();
        
    }
    
    
    public static void main(String[] args) {
        toStr(123);
    }
}
