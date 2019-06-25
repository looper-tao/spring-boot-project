package com.boot.learn.untils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: taozhengzhi
 * @Date: 2019/6/24 下午2:27
 * @Version 1.0
 */
public class StringUtils {
    private static final Pattern p = Pattern.compile("\\s*|\t|\r|\n");
    
    public static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }
    
    
    public static void main(String[] args) {
        String str =  "436435(旧)254";
    
        int indexOf = str.indexOf("(旧)");
        
        System.out.println(str.substring(0,indexOf));
    }
}
