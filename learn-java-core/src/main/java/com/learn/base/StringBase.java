package com.learn.base;

import lombok.Builder;
import lombok.Data;

/**
 * @Author: taozhengzhi
 * @Date: 2019/6/24 上午10:32
 * @Version 1.0
 */
@Data
@Builder
public class StringBase {
    
    private String a1;
    private String a2;
    private String a3;
    
    public static void main(String[] args) {
        StringBase build = StringBase.builder().a1("1")
            .a2("2").a3(null).build();
        System.out.println(build);
    }
}

