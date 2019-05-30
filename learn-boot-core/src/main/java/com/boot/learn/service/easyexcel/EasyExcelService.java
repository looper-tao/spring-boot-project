package com.boot.learn.service.easyexcel;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.boot.learn.entity.QStudent;
import com.boot.learn.entity.Student;
import com.boot.learn.model.easyexcell.StudentInfoDTO;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: taozhengzhi
 * @Date: 2019/5/30 下午6:04
 * @Version 1.0
 */

@Slf4j
@Service
public class EasyExcelService {
    private final String DOWNLOAD_URL = "/Users/yeguxin/Documents/test/easyexcell/student.xlsx";
    
    @Autowired
    private JPAQueryFactory queryFactory;
    
    /**
     * excel 写入方法  最基础版本
     *
     * @throws IOException
     */
    public void writeExcel() throws IOException {
        
        // 文件的输出位置
        OutputStream outputStream = new FileOutputStream(DOWNLOAD_URL);
        
        ExcelWriter writer = EasyExcelFactory.getWriter(outputStream);
        
        // 写仅有一个 Sheet的 Excell文件
        Sheet sheet = new Sheet(1, 0, StudentInfoDTO.class);
        
        sheet.setSheetName("学生信息");
        
        // 写数据到 Writer
        writer.write(getStudentInfoDTOList(), sheet);
        
        // 将上下文中的最终 输出的流写入到文件中
        writer.finish();
        
        // 关闭流
        outputStream.close();
        
        log.info("excel 已写入!!!");
    }
    
    private List<StudentInfoDTO> getStudentInfoDTOList() {
        List<Student> studentList = queryFactory.select(QStudent.student)
            .from(QStudent.student)
            .fetch();
        
        List<StudentInfoDTO> studentInfoDTOList = studentList.stream().map(student -> {
            StudentInfoDTO studentInfoDTO = StudentInfoDTO
                .builder()
                .id(student.getId())
                .name(student.getName())
                .age(student.getAge())
                .birthday(student.getBirthday())
                .reamrk(student.getReamrk())
                .score(student.getScore())
                .createAt(student.getCreateAt())
                .build();
            
            return studentInfoDTO;
        }).collect(Collectors.toList());
        
        return studentInfoDTOList;
    }
}
