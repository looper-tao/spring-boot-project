package com.boot.learn.model.easyexcell;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @Author: taozhengzhi
 * @Date: 2019/5/30 下午6:21
 * @Version 1.0
 */

@Builder
@Data
@AllArgsConstructor
public class StudentInfoDTO extends BaseRowModel {
    @ExcelProperty(value = "主键Id", index = 0)
    private Long id;
    
    @ExcelProperty(value = "姓名", index = 1)
    private String name;
    
    @ExcelProperty(value = "年龄", index = 2)
    private Integer age;
    
    @ExcelProperty(value = "生日", index = 3)
    private Date birthday;
    
    @ExcelProperty(value = "备注", index = 4)
    private String reamrk;
    
    @ExcelProperty(value = "成绩", index = 5)
    private Integer score;
    
    @ExcelProperty(value = "创建时间", index = 6)
    private Date createAt;
}
