package com.boot.learn.service.html;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: yeguxin
 * @date: 2020/12/7
 * @description:
 */
@Slf4j
@Service
public class TouSuHtmlService {
    public void parseHtml() {
        // 新建一个模拟谷歌Chrome浏览器的浏览器客户端对象
        final WebClient webClient = new WebClient(BrowserVersion.CHROME);
        //当JS执行出错的时候是否抛出异常, 这里选择不需要
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        //当HTTP的状态非200时是否抛出异常, 这里选择不需要
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setActiveXNative(false);
        //是否启用CSS, 因为不需要展现页面, 所以不需要启用
        webClient.getOptions().setCssEnabled(false);
        //很重要，启用JS
        webClient.getOptions().setJavaScriptEnabled(true);
        //很重要，设置支持AJAX
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        
        HtmlPage page = null;
        try {
            //尝试加载上面图片例子给出的网页
            page = webClient.getPage("XXX");
            //异步JS执行需要耗时,所以这里线程要阻塞20秒,等待异步JS执行结束
            webClient.waitForBackgroundJavaScript(20000);
           
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            webClient.close();
        }
        
        //直接将加载完成的页面转换成xml格式的字符串
        String pageXml = page.asXml();
        //获取html文档
        Document document = Jsoup.parse(pageXml);
        //获取元素节点等
        List<Element> infoListEle = document.getElementsByClass("box");
        infoListEle.forEach(element -> {
            System.out.println(element.attr("href"));
        });
    
    }
    
    public static void main(String[] args) {
        TouSuHtmlService service = new TouSuHtmlService();
        service.parseHtml();
    }
}
