package com.boot.learn.untils;

import lombok.Getter;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
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
    
    /**
     * 昨天的开始
     *
     * @return
     */
    public static Date yesterdayBegin() {
        return Date.from(LocalDateTime.of(getCurrentDate().plusDays(-1L), LocalTime.MIN).atZone(ZoneId.systemDefault()).toInstant());
    }
    
    /**
     * 昨天的结束
     *
     * @return
     */
    public static Date yesterdayEnd() {
        return Date.from(LocalDateTime.of(getCurrentDate().plusDays(-1L), LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant());
    }
    
    /**
     * 明天的开始
     *
     * @return
     */
    public static Date tomorrowBegin() {
        return Date.from(LocalDateTime.of(getCurrentDate().plusDays(1L), LocalTime.MIN).atZone(ZoneId.systemDefault()).toInstant());
    }
    
    /**
     * 明天的结束
     *
     * @return
     */
    public static Date tomorrowEnd() {
        return Date.from(LocalDateTime.of(getCurrentDate().plusDays(1L), LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant());
    }
    
    /**
     * 指定天的开始
     *
     * @param date 指定日期
     * @return
     */
    public static Date startTime(Date date) {
        return Date.from(LocalDateTime.of(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).toLocalDate(), LocalTime.MIN).atZone(ZoneId.systemDefault()).toInstant());
    }
    
    /**
     * 指定天的结束
     *
     * @param date
     * @return
     */
    public static Date endTime(Date date) {
        return Date.from(LocalDateTime.of(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).toLocalDate(), LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant());
    }
    
    /**
     * 当月的第一天
     *
     * @return
     */
    public static Date monthBegin() {
        return Date.from(LocalDateTime.of(getCurrentDate().with(TemporalAdjusters.firstDayOfMonth()), LocalTime.MIN).atZone(ZoneId.systemDefault()).toInstant());
    }
    
    /**
     * 当月的最后一天
     *
     * @return
     */
    public static Date monthEnd() {
        return Date.from(LocalDateTime.of(getCurrentDate().with(TemporalAdjusters.lastDayOfMonth()), LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant());
    }
    
    /**
     * 指定月的第一天
     *
     * @param date
     * @return
     */
    public static Date theMonthBegin(Date date) {
        return Date.from(LocalDateTime.of(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).with(TemporalAdjusters.firstDayOfMonth()).toLocalDate(), LocalTime.MIN).atZone(ZoneId.systemDefault()).toInstant());
    }
    
    /**
     * 指定月的最后一天
     *
     * @param date
     * @return
     */
    public static Date theMonthEnd(Date date) {
        return Date.from(LocalDateTime.of(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).with(TemporalAdjusters.lastDayOfMonth()).toLocalDate(), LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant());
    }
    
    /**
     * 指定年的第一天
     *
     * @param date
     * @return
     */
    public static Date theYearBegin(Date date) {
        return Date.from(LocalDateTime.of(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).with(TemporalAdjusters.firstDayOfYear()).toLocalDate(), LocalTime.MIN).atZone(ZoneId.systemDefault()).toInstant());
    }
    
    /**
     * 指定年的第一天
     *
     * @param date
     * @return
     */
    public static Date theYearEnd(Date date) {
        return Date.from(LocalDateTime.of(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).with(TemporalAdjusters.lastDayOfYear()).toLocalDate(), LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant());
    }
    
    /**
     * 判断传入时间是否是今天
     *
     * @param date
     * @return
     */
    public static Boolean checkIsToday(Date date) {
        return getCurrentDate().equals(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).toLocalDate());
    }
    
    /**
     * 计算一段时间的间隔
     * duration.toDays() 计算这段时间的总天数(满24小时为1天)
     * duration.toHours() 计算这段时间的总小时数(满60分钟为1小时)
     * duration.toMinutes() 计算这段时间的总分钟数(满60秒为1分钟)
     * duration.getSeconds() 计算这段时间的总秒数(满1000毫秒为1秒)
     * duration.toMillis() 计算这段时间的总毫秒数
     * duration.toNanos() 计算这段时间的总纳秒数
     *
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @return
     */
    public static Duration between(Date beginTime, Date endTime) {
        LocalDateTime beginLocalDateTime = LocalDateTime.ofInstant(beginTime.toInstant(), ZoneId.systemDefault());
        LocalDateTime endLocalDateTime = LocalDateTime.ofInstant(endTime.toInstant(), ZoneId.systemDefault());
        return Duration.between(beginLocalDateTime, endLocalDateTime);
    }
    
    /**
     * 指定日期的几天前
     * @param date 指定日期
     * @param num 向前的天数
     * @return
     */
    public static Date theDayBefor(Date date, long num) {
        return Date.from(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).minusDays(num).atZone(ZoneId.systemDefault()).toInstant());
    }
    
    /**
     * 指定日期的几天后
     * @param date 指定日期
     * @param num 向后的天数
     * @return
     */
    public static Date theDayLater(Date date, long num){
        return Date.from(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).plusDays(num).atZone(ZoneId.systemDefault()).toInstant());
    }
    
    public static Date theMonthLater(Date date, long num){
        return Date.from(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).plusMonths(num).atZone(ZoneId.systemDefault()).toInstant());
    }
    
    
    public static void main(String[] args) {
        String time = "2020-03-01 00:00:00";
        Date date = parseDate(time, DateTimeFormatterEnum.FORMAT_DATE_TIME_STYLE_1);
        System.out.println(format(theMonthLater(date,1),DateTimeFormatterEnum.FORMAT_DATE_TIME_STYLE_1));
    }
    
    
    /**
     * 日期格式枚举
     */
    public enum DateTimeFormatterEnum {
        /**
         * yyyy/MM/dd (仅格式化时间可用)
         */
        FORMAT_DATE_STYLE_1("yyyy/MM/dd", DateTimeFormatter.ofPattern("yyyy/MM/dd")),
        /**
         * yyyy-MM-dd (仅格式化时间可用)
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
