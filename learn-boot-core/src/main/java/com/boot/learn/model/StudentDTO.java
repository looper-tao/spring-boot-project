package com.boot.learn.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: taozhengzhi
 * @Date: 2019/4/24 下午4:18
 * @Version 1.0
 */

@Data
@AllArgsConstructor
public class StudentDTO {
    private String schoolName;
    private String name;
    private Integer source;
}
