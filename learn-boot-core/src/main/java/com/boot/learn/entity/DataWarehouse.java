package com.boot.learn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: yeguxin
 * @date: 2020/1/6
 * @description:
 */
@Data
public class DataWarehouse implements Serializable {
    private Long id;
    
    /**
     * 投放Id
     */
    private String adCode;
    
    /**
     * 领取时间
     */
    private Date createAt;
    
    /**
     * 姓名
     */
    private String name;
    
    /**
     * 性别
     */
    private Sex sex;
    
    /**
     * 手机号
     */
    private String mobile;
    
    /**
     * ip地址
     */
    private String ipAddress;
    
    /**
     * 验证码
     */
    private String capacha;
    
    /**
     * 省份
     */
    private String province;
    
    /**
     * 城市
     */
    private String city;
    
    /**
     * 年级
     */
    private Grade grade;
    
    /**
     * 问卷信息
     */
    private String question;
    
    /**
     * 产品id
     */
    private Long productId;
    
    /**
     * 附加信息
     */
    private String appendInfo;
    
    /**
     * 领取结果
     */
    private Result result;
    
    public enum Result {
        /**
         * 成功
         */
        SUCCESS,
        /**
         * 失败
         */
        FAIL;
    }
    
    /**
     * 年级
     */
    @Getter
    @AllArgsConstructor
    public enum Grade {
        /**
         * 幼儿园小班
         */
        LOW_CLASS_K(1, "幼儿园小班"),
        /**
         * 幼儿园中班
         */
        MIDDLE_CLASS_K(2, "幼儿园中班"),
        /**
         * 幼儿园大班
         */
        HIGH_CLASS_K(3, "幼儿园大班"),
        /**
         * 小学一年级
         */
        FIRST_GRADE_P(4, "小学一年级"),
        /**
         * 小学二年级
         */
        SECOND_GRADE_P(5, "小学二年级"),
        /**
         * 小学三年级
         */
        THIRD_GRADE_P(6, "小学三年级"),
        /**
         * 小学四年级
         */
        FOURTH_GRADE_P(7, "小学四年级"),
        /**
         * 小学五年级
         */
        FIFTH_GRADE_P(8, "小学五年级"),
        /**
         * 小学六年级
         */
        SIXTH_GRADE_P(9, "小学六年级"),
        /**
         * 初中一年级
         */
        FIRST_GRADE_M(10, "初中一年级"),
        /**
         * 初中二年级
         */
        SECOND_GRADE_M(11, "初中二年级"),
        /**
         * 初中三年级
         */
        THIRD_GRADE_M(12, "初中三年级"),
        /**
         * 高中一年级
         */
        FIRST_GRADE_H(13, "高中一年级"),
        /**
         * 高中二年级
         */
        SECOND_GRADE_H(14, "高中二年级"),
        /**
         * 高中三年级
         */
        THIRD_GRADE_H(15, "高中三年级"),
        /**
         * 成人
         */
        ADULT(20, "成人");
        
        private Integer value;
        private String name;
    }
    
    public enum Sex {
        /**
         * 男
         */
        MALE,
        /**
         * 女
         */
        FEMALE;
    }
    
}
