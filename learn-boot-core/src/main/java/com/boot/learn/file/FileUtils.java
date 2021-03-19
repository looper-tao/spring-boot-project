package com.boot.learn.file;

import java.io.*;

/**
 * @author: yeguxin
 * @date: 2021/2/19
 * @description:
 */
public class FileUtils {
    
    public static void main(String[] args) throws IOException {
        String filePath = "/Users/yeguxin/Desktop/";
        String readFileName = "jihuoma.txt";
        String writeFileName = "taipingjihuoma.sql";
        BufferedWriter bw = null;
        BufferedReader br = null;
        try {
            File readFile = new File(filePath + readFileName);
            File writeFile = new File(filePath + writeFileName);
            
            InputStreamReader reader = new InputStreamReader(new FileInputStream(readFile));
            br = new BufferedReader(reader);
            String line;
            bw = new BufferedWriter(new FileWriter(writeFile));
            int count = 0;
            while((line = br.readLine()) != null) {
                bw.write("INSERT INTO `taiping_jihuoma` (`code`,`effective`,`warehouse_id`) VALUES ('" + line + "',1,null);\r\n");
                count++;
            }
            System.out.println("完成! count = "+count);
            
        } catch(Exception e) {
            if(br != null) {
                br.close();
            }
            if(bw != null) {
                bw.flush();
            }
            if(bw != null) {
                bw.close();
            }
        }
        
    }
    
    
}
