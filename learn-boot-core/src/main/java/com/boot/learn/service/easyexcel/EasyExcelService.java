package com.boot.learn.service.easyexcel;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.boot.learn.entity.QStudent;
import com.boot.learn.entity.Student;
import com.boot.learn.model.easyexcell.StudentInfoDTO;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
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
    public void writeExcel1() throws IOException {
        
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
    
    public void writeExcel2() throws IOException {
        // 文件的输出位置
        OutputStream outputStream = new FileOutputStream(DOWNLOAD_URL);
    
        ExcelWriter writer = EasyExcelFactory.getWriter(outputStream);
    
        // 写仅有一个 Sheet的 Excell文件
        Sheet sheet = new Sheet(1, 0);
        sheet.setSheetName("学生信息");
    
        //创建一个表格,用于Sheet中使用
        Table table = new Table(1);
        
        //无注解模式,动态添加表头
        table.setHead(getHead());
        
        writer.write1(getDataList(),sheet,table);
        
        writer.finish();
        
        outputStream.close();
        
        log.info("excel 写入成功!!!");
    }
    
    private List<List<String>> getHead(){
        
        List<List<String>> head = new ArrayList<>();
    
        List<String> headCoulumn1 = new ArrayList<String>();
        List<String> headCoulumn2 = new ArrayList<String>();
        List<String> headCoulumn3 = new ArrayList<String>();
        List<String> headCoulumn4 = new ArrayList<String>();
        List<String> headCoulumn5 = new ArrayList<String>();
        List<String> headCoulumn6 = new ArrayList<String>();
        List<String> headCoulumn7 = new ArrayList<String>();
        
        headCoulumn1.add("主键Id");
        headCoulumn2.add("姓名");
        headCoulumn3.add("年龄");
        headCoulumn4.add("生日");
        headCoulumn5.add("备注");
        headCoulumn6.add("成绩");
        headCoulumn7.add("创建时间");
    
        head.add(headCoulumn1);
        head.add(headCoulumn2);
        head.add(headCoulumn3);
        head.add(headCoulumn4);
        head.add(headCoulumn5);
        head.add(headCoulumn6);
        head.add(headCoulumn7);
        return head;
    }
    
    private List<List<Object>> getDataList(){
        List<Student> studentList = queryFactory.select(QStudent.student)
            .from(QStudent.student)
            .fetch();
    
        List<List<Object>> data = studentList.stream().map(student -> {
            List<Object> dataList = new ArrayList<>();
        
            dataList.add(student.getId());
            dataList.add(student.getName());
            dataList.add(student.getAge());
            dataList.add(student.getBirthday());
            dataList.add(student.getReamrk());
            dataList.add(student.getScore());
            dataList.add(student.getCreateAt());
        
            return dataList;
        }).collect(Collectors.toList());
        
        return data;
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
