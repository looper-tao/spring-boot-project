package com.learn.jvm.chapter7;

/**
 * @author: yeguxin
 * @date: 2019/11/21
 * @description:
 */
public class Test {
    static int i = 1;
    static {
        i = 0;  //  给变量复制可以正常编译通过
        System.out.print(i);  // 这句编译器会提示“非法向前引用”
    }
//    static int i = 1;
}
