package com.boot.learn.untils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Base64 编码,解码
 * @Author: taozhengzhi
 * @Date: 2019/4/3 下午2:14
 * @Version 1.0
 */

public class DataBase64Encoder implements DataEncoder {
    
    private static final DataEncoder INSTANCE = new DataBase64Encoder();
    private static final String CHARSET = "utf-8";
    
    public static DataEncoder getInstance() {
        return INSTANCE;
    }
    
    private DataBase64Encoder() {
    }
    
    /**
     * 编码
     * @param s
     * @return
     */
    public String encode(String s) {
        try {
            return Base64.getEncoder().encodeToString(s.getBytes(CHARSET));
        } catch (UnsupportedEncodingException ignored) {
        }
        return null;
    }
    
    /**
     * 解码
     * @param s
     * @return
     */
    public String decode(String s) {
        try {
            return new String(Base64.getDecoder().decode(s), CHARSET);
        } catch (UnsupportedEncodingException ignored) {
        }
        return null;
    }
    
}
