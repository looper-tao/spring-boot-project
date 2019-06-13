package com.boot.learn.controller;

import com.boot.learn.model.StudentDTO;
import com.boot.learn.untils.KJsonUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: taozhengzhi
 * @Date: 2019/6/13 下午2:40
 * @Version 1.0
 */

@RestController
@RequestMapping("annotation/test")
public class AnnotationTestController {
    
    
    /**
     * 例子: localhost:8080/student/test/123?param1=456
     *
     * body(json)
     *
     * {
     * 	"schoolName":"山东理工大学",
     * 	"name":"konggege",
     * 	"source":100
     * }
     *
     * @RequestParam 注解: 获取url的 ? 后的参数       -- param1
     * @RequestBody 注解: 获取post请求中body的参数    -- body
     * @PathVariable 注解: 获取url中的参数           -- 123
     *
     * @param param1
     * @param studentDTO
     * @param code
     */
    @RequestMapping(value = "test/{code}", method = RequestMethod.POST)
    public void test(@RequestParam("param1") String param1,
                     @RequestBody StudentDTO studentDTO,
                     @PathVariable("code") String code) {
        System.out.println(param1);
        System.out.println(KJsonUtils.toJson(studentDTO));
        System.out.println(code);
    }
}
