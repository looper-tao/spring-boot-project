package com.boot.learn.controller.excelhandle;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author: yeguxin
 * @date: 2019/9/18
 * @description:
 */
@RestController
@RequestMapping("dynamic")
public class DynamicLinkController {
    
    /**
     * 动态码sql创建接口
     *
     * @param multipartFile
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "link", method = RequestMethod.POST)
    public StringBuilder buildLinkSql(@RequestParam("excel") MultipartFile multipartFile) throws IOException {
        InputStream inputStream = multipartFile.getInputStream();
        ExcelReader reader = ExcelUtil.getReader(inputStream);
        List<Map<String, Object>> mapList = reader.readAll();
        
        StringBuilder result = new StringBuilder();
        
        for(Map<String, Object> map : mapList) {
            String sql = "INSERT INTO `qmxbb_dynamic_link` ( `first_party`, `project`, `daily_limit`, `total_limit`, `effective_at`, `link`, `link_type`, `month`, `status`, `create_at`," +
                "`utm_sources` ) " +
                "VALUES ( '{甲方}', '{项目}', {每日限量}, {总限量}, '{有效时间}', '{链接}', '{链接类型}', '{月份}', 'ENABLED', NOW(),'{渠道}' );"
                    .replace("{甲方}", String.valueOf(map.get("甲方")))
                    .replace("{项目}", String.valueOf(map.get("项目")))
                    .replace("{每日限量}", String.valueOf(map.get("每日限量")))
                    .replace("{总限量}", String.valueOf(map.get("总限量")))
                    .replace("{有效时间}", String.valueOf(map.get("有效时间")))
                    .replace("{链接}", String.valueOf(map.get("链接")))
                    .replace("{链接类型}", String.valueOf(map.get("链接类型")))
                    .replace("{月份}", String.valueOf(map.get("月份")))
                    .replace("{渠道}", String.valueOf(map.get("渠道")));
            
            result.append(sql);
            result.append("\n");
        }
        
        return result;
    }
    
    
    /**
     * 投放
     *
     * @param multipartFile
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "ad/code", method = RequestMethod.POST)
    public StringBuilder buildAdcodeSql(@RequestParam("excel") MultipartFile multipartFile) throws IOException {
        InputStream inputStream = multipartFile.getInputStream();
        ExcelReader reader = ExcelUtil.getReader(inputStream);
        List<Map<String, Object>> mapList = reader.readAll();
        
        StringBuilder result = new StringBuilder();
        
        for(Map<String, Object> map : mapList) {
            String sql = "insert into `qmxbb_ad_link` (`ad_link_code`,`create_at`,`link_count`)" +
                "values('{页面Code}', NOW(),{筛选条数});"
                    .replace("{页面Code}", String.valueOf(map.get("页面Code")))
                    .replace("{筛选条数}", String.valueOf(map.get("筛选条数")));
            
            result.append(sql);
            result.append("\n");
        }
        
        return result;
    }
    
    
    /**
     * 筛选条件
     *
     * @param multipartFile
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "filter/condition", method = RequestMethod.POST)
    public StringBuilder filterCondition(@RequestParam("excel") MultipartFile multipartFile) throws IOException {
        InputStream inputStream = multipartFile.getInputStream();
        ExcelReader reader = ExcelUtil.getReader(inputStream);
        List<Map<String, Object>> mapList = reader.readAll();
        
        StringBuilder result = new StringBuilder();
        for(Map<String, Object> map : mapList) {
            String sql = "insert into `qmxbb_dynamic_link_filter_condition` (`ad_link_id`,`exclude_first_parties`,`first_parties`,`link_count`,`link_types`,`match_mode`,`priority`,`projects`)" +
                "values((SELECT id FROM `qmxbb_ad_link` WHERE `ad_link_code` ='{页面Code}'),{排除甲方},'{甲方}',{筛选条数},'{链接类型}','{匹配模式}',{优先级},'{项目}');"
                    .replace("{页面Code}", String.valueOf(map.get("页面Code")))
                    .replace("{排除甲方}",
                        Objects.requireNonNull(Optional.ofNullable(map.get("排除甲方"))
                            .map(o -> "'" + String.valueOf(o) + "'")
                            .orElse("NULL")))
                    .replace("{甲方}", String.valueOf(map.get("甲方")))
                    .replace("{筛选条数}", String.valueOf(map.get("筛选条数")))
                    .replace("{链接类型}", String.valueOf(map.get("链接类型")))
                    .replace("{匹配模式}", String.valueOf(map.get("匹配模式")))
                    .replace("{优先级}", String.valueOf(map.get("优先级")))
                    .replace("{项目}", String.valueOf(map.get("项目")));
            
            result.append(sql);
            result.append("\n");
        }
        
        return result;
    }
}
