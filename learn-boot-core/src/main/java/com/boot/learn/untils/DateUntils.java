package com.boot.learn.untils;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 时间工具类
 *
 * @Author: taozhengzhi
 * @Date: 2019/4/4 上午10:10
 * @Version 1.0
 */
public class DateUntils {
    /**
     * 获取当前日期 格式为 (xxxx-xx-xx)
     *
     * @return
     */
    public static LocalDate getCurrentDate() {
        return LocalDate.now();
    }
    
    /**
     * 获取当前时间 格式为 (xxxx-xx-xx xx:xx:xx.xxx)
     *
     * @return
     */
    public static LocalDateTime getLocalDateTime() {
        return LocalDateTime.now();
    }
    
    /**
     * Date 转化为 格式化时间
     *
     * @param date    待转化的date
     * @param pattern 时间格式
     * @return
     */
    public static String format(Date date, DateTimeFormatterEnum pattern) {
        return format(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()), pattern);
    }
    
    /**
     * LocalDateTime 转换为格式化时间
     *
     * @param localDateTime 待转化的localDateTime
     * @param pattern       时间格式
     * @return
     */
    public static String format(LocalDateTime localDateTime, DateTimeFormatterEnum pattern) {
        return localDateTime.format(pattern.formatter);
    }
    
    /**
     * 字符串转为格式化Date
     *
     * @param date    时间字符串
     * @param pattern 时间格式
     * @return
     */
    public static Date parseDate(String date, DateTimeFormatterEnum pattern) {
        return Date.from(parseLocalDateTime(date, pattern).atZone(ZoneId.systemDefault()).toInstant());
    }
    
    /**
     * 字符串转格式化LocalDateTime
     *
     * @param date    时间字符串
     * @param pattern 时间格式
     * @return
     */
    public static LocalDateTime parseLocalDateTime(String date, DateTimeFormatterEnum pattern) {
        return LocalDateTime.parse(date, pattern.formatter);
    }
    
    /**
     * 今天的开始
     *
     * @return
     */
    public static Date todayBegin() {
        return Date.from(LocalDateTime.of(getCurrentDate(), LocalTime.MIN).atZone(ZoneId.systemDefault()).toInstant());
    }
    
    /**
     * 今天的结束
     *
     * @return
     */
    public static Date todayEnd() {
        return Date.from(LocalDateTime.of(getCurrentDate(), LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant());
    }
    
    public static void main(String[] args) {
        System.out.println(todayBegin());
    }
    
    
    /**
     * 日期格式枚举
     */
    public enum DateTimeFormatterEnum {
        /**
         * yyyy/MM/dd
         */
        FORMAT_DATE_STYLE_1("yyyy/MM/dd", DateTimeFormatter.ofPattern("yyyy/MM/dd")),
        /**
         * yyyy-MM-dd
         */
        FORMAT_DATE_STYLE_2("yyyy-MM-dd", DateTimeFormatter.ofPattern("yyyy-MM-dd")),
        /**
         * yyyyMMdd
         */
        FORMAT_DATE_STYLE_3("yyyyMMdd", DateTimeFormatter.ofPattern("yyyyMMdd")),
        /**
         * YYYY/M/d
         */
        FORMAT_DATE_STYLE_4("YYYY/M/d", DateTimeFormatter.ofPattern("YYYY/M/d")),
        /**
         * YYYY.M.d
         */
        FORMAT_DATE_STYLE_5("YYYY.M.d", DateTimeFormatter.ofPattern("YYYY.M.d")),
        /**
         * yyyy-MM
         */
        FORMAT_DATE_STYLE_6("yyyy-MM", DateTimeFormatter.ofPattern("yyyy-MM")),
        /**
         * yyyy-MM-dd HH:mm:ss
         */
        FORMAT_DATE_TIME_STYLE_1("yyyy-MM-dd HH:mm:ss", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
        /**
         * yyyyMMddHHmmss
         */
        FORMAT_DATE_TIME_STYLE_2("yyyyMMddHHmmss", DateTimeFormatter.ofPattern("yyyyMMddHHmmss")),
        /**
         * yyyyMMddHHmm
         */
        FORMAT_DATE_TIME_STYLE_3("yyyyMMddHHmm", DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
        
        @Getter
        private String value;
        @Getter
        private DateTimeFormatter formatter;
        
        DateTimeFormatterEnum(String value, DateTimeFormatter formatter) {
            this.value = value;
            this.formatter = formatter;
        }
    }
}
