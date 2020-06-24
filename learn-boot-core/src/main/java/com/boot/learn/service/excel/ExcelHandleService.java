package com.boot.learn.service.excel;

import com.boot.learn.exception.InvalidParamException;
import com.boot.learn.untils.LocalStringUtils;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;


/**
 * @Author: taozhengzhi
 * @Date: 2019/6/24 上午10:47
 * @Version 1.0
 */
@Service
public class ExcelHandleService {
    
    private static final String[] TYPES = new String[]{"xls", "xlsx"};
    public static final Set<String> ALLOW_TYPES = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(TYPES)));
    
    public Sheet checkExcel2Jxl(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        if(!ALLOW_TYPES.contains(fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase())) {
            throw new InvalidParamException("文件格式不支持!");
        }
        Workbook workbook = null;
        try {
            workbook = Workbook.getWorkbook(file.getInputStream());
        } catch(BiffException e) {
            System.out.println(e.getMessage());
            throw new InvalidParamException("解析文件失败");
        }
        jxl.Sheet sheet = workbook.getSheet(0);
        if(null == sheet) {
            throw new InvalidParamException("sheet不存在");
        }
        return sheet;
    }
    
    /**
     * 职业码表excel解析
     * @param sheet
     * @return
     */
    public List<StringBuilder> getJobForExcel(Sheet sheet) {
        List<StringBuilder> sbList = new ArrayList<>();
        
        String firstCode = null;
        String firstContent = null;
        String firstCell = null;
        
        String secondCode = null;
        String secondContent = null;
        String secondCell = null;
        
        String thirdCode = null;
        String thirdContent = null;
        String thirdCell = null;
        
        String fourthCode = null;
        String fourthContent = null;
        String fourthCell = null;
        
        int firstKey = 0;
        int secondKey = 0;
        int thirdKey = 0;
        int fourthKey = 0;
        int index = 0;
    
        String firstTemp = null;
        String secondTemp = null;
        String thirdTemp = null;
        String fourthTemp = null;
        
        for(int i = 2; i < 2200; i++) {
            
            String firstValue = LocalStringUtils.replaceBlank(sheet.getCell(0, i).getContents().trim());
            
            String secondValue = sheet.getCell(1, i).getContents().trim();
            
            String thirdValue = sheet.getCell(2, i).getContents().trim();
            
            String fourthValue = sheet.getCell(3, i).getContents().trim();
            
            String fifth = sheet.getCell(4, i).getContents().trim();
            
            String sixthValue = sheet.getCell(5, i).getContents().trim();
            
            
            if(firstValue != null && !firstValue.isEmpty() && !firstValue.equals(firstCell)) {
                firstCode = firstValue.substring(4, 5);
                firstContent = firstValue.substring(5);
    
                index++;
                firstKey++;
                
                StringBuilder sb = new StringBuilder();
                sb = sb.append("INSERT INTO `t_prop` (`clazz`, `code`, `index_`, `key_`, `pcode`, `remark`, `tenant_id`, `value_`, `visible` ) " +
                    "VALUES ('job',");
    
                firstTemp = String.format("%04d",firstKey);
                
                sb.append("'" + firstTemp + "',");
                sb.append(index+",");
                sb.append("'" + firstCode + "',");
                sb.append("0000,");
                sb.append("NULL,");
                sb.append("6,");
                sb.append("'" + firstContent + "',");
                sb.append("1);\n");
                
                sbList.add(sb);
                firstCell = firstValue;
                secondKey = 0;
                
            }
            if(secondValue != null && !secondValue.isEmpty() && !secondValue.equals(secondCell)) {
                
                secondCode = secondValue.substring(0, 3);
                
                secondContent = secondValue.substring(3);
                
                
                secondKey++;
                index++;
                
                StringBuilder sb = new StringBuilder();
                sb = sb.append("INSERT INTO `t_prop` (`clazz`, `code`, `index_`, `key_`, `pcode`, `remark`, `tenant_id`, `value_`, `visible` ) " +
                    "VALUES ('job',");
    
                secondTemp = String.format("%04d",secondKey);
                
                sb.append("'" + firstTemp + secondTemp + "',");
                sb.append(index+",");
                sb.append("'" + secondCode + "',");
                sb.append("'" + firstTemp + "',");
                sb.append("NULL,");
                sb.append("6,");
                sb.append("'" + secondContent + "',");
                sb.append("1);\n");
                
                sbList.add(sb);
                
                secondCell = secondValue;
                thirdKey = 0;
                
            }
            
            if(thirdValue != null && !thirdValue.isEmpty() && !thirdValue.equals(thirdCell)) {
                
                thirdCode = thirdValue.substring(0, 5);
                thirdContent = thirdValue.substring(5);
    
    
                index++;
                thirdKey++;
                
                StringBuilder sb = new StringBuilder();
                sb = sb.append("INSERT INTO `t_prop` (`clazz`, `code`, `index_`, `key_`, `pcode`, `remark`, `tenant_id`, `value_`, `visible` ) " +
                    "VALUES ('job',");
    
                thirdTemp = String.format("%04d",thirdKey);
                
                sb.append("'" + firstTemp+secondTemp+thirdTemp + "',");
                sb.append(index+",");
                sb.append("'" + thirdCode + "',");
                sb.append("'" + firstTemp+secondTemp + "',");
                sb.append("NULL,");
                sb.append("6,");
                sb.append("'" + thirdContent + "',");
                sb.append("1);\n");
                
                sbList.add(sb);
                
                thirdCell = thirdValue;
                fourthKey = 0;
            }
            
            if(fourthValue != null && !fourthValue.isEmpty() && !fourthValue.equals(fourthCell)) {
                fourthCode = fourthValue.substring(0, 7);
                fourthContent = fourthValue.substring(7);
    
                index++;
                fourthKey++;
                
                StringBuilder sb = new StringBuilder();
                sb = sb.append("INSERT INTO `t_prop` (`clazz`, `code`, `index_`, `key_`, `pcode`, `remark`, `tenant_id`, `value_`, `visible` ) " +
                    "VALUES ('job',");
    
                fourthTemp = String.format("%04d",fourthKey);
                
                sb.append("'" + firstTemp+secondTemp+thirdTemp+fourthTemp + "',");
                sb.append(index+",");
                sb.append("'" + fourthCode + "',");
                sb.append("'" + firstTemp+secondTemp+thirdTemp + "',");
                sb.append("NULL,");
                sb.append("6,");
    
                int indexOf = fourthContent.indexOf("(旧)");
                
                sb.append("'" + (indexOf == -1 ? fourthContent:fourthContent.substring(0,indexOf)) + "',");
                sb.append("1);\n");
    
    
    
//                StringBuilder sb = new StringBuilder();
//                sb = sb.append("INSERT INTO `t_bn_job`(`id`, `life_insurance_level`, `medical_ insurance_level`) VALUES (");
//
//                sb.append("'" + fourthCode+"',");
//                sb.append(fifth+",");
//                sb.append(sixthValue+");\n");
                
                
                
                sbList.add(sb);
                
                fourthCell = fourthValue;
                
            }
            
        }
        return sbList;
    }
    
    
    /**
     * 职业码表
     * @param jobFile
     * @throws IOException
     */
    public void parseJob(MultipartFile jobFile) throws IOException {
        
        Sheet sheet = checkExcel2Jxl(jobFile);
        
        List<StringBuilder> builderList = getJobForExcel(sheet);
        
        
        builderList.stream().forEach(sb -> System.out.println(sb));
    }
    
    
    
    public void parseBank(MultipartFile bankFile) throws IOException {
        Sheet sheet = checkExcel2Jxl(bankFile);
    
        List<StringBuilder> builderList = getBankInfoForExcel(sheet);
        
        builderList.stream().forEach(stringBuilder -> System.out.println(stringBuilder));
    
    }
    
    /**
     * 银行码表excel解析
     * @param sheet
     */
    private List<StringBuilder> getBankInfoForExcel(Sheet sheet) {
        int firstKey = 0;
        int firstIndex = 0;
        
        List<StringBuilder> sbList = new ArrayList<>();
        
        for(int i = 0; i < 16; i++) {
            String firstValue = sheet.getCell(0, i).getContents().trim();
            String secondValue = sheet.getCell(1, i).getContents().trim();
    
            firstKey++;
            firstIndex++;
            
            StringBuilder sb = new StringBuilder();
            sb = sb.append("INSERT INTO `scorpio_paas`.`t_prop` (`clazz`, `code`, `index_`, `key_`, `pcode`, `remark`, `tenant_id`, `value_`, `visible` ) " +
                "VALUES ('relationShip',");
            
            sb.append((firstKey>=10? "'0":"'00") + (firstKey  + "',"));
            sb.append(firstIndex+",");
            sb.append("'" + firstValue + "',");
            sb.append("'000',");
            sb.append("NULL,");
            sb.append("6,");
            sb.append("'" + secondValue + "',");
            sb.append("b '1');\n");
    
            sbList.add(sb);
        }
        
        return sbList;
    }
}
