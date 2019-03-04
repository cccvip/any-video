package com.xiao.schedule;

import com.xiao.crawel.BibilPageProcessor;
import com.xiao.crawel.BibilPipeline;
import com.xiao.crawel.TencentPageProcessor;
import com.xiao.crawel.TencentPipeline;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

/**
 * @author carl-Xiao
 * http://www.pppet.net/ cron在线表达式生成器
 */
@Component
@Slf4j
public class VideoScheduled {
    @Autowired
    BibilPipeline bibilPipeline;
    @Autowired
    TencentPipeline tencentPipeline;


    /**
     * 每周一10点AM。8点PM
     */
    @Scheduled(cron = "0 0 10,20 ? * MON")
    public void runningMan() {
        //2018数据已经不合更新，没必要再采集
        //2019数据采集
        log.info("开始采集RunningMan2019合集");
        Spider spider = Spider.create(new BibilPageProcessor());
        spider.addUrl("https://www.bilibili.com/video/av40112794");
        spider.addPipeline(bibilPipeline);
        spider.setExitWhenComplete(true);
        spider.start();
    }
    /**
     * 电视剧
     */
    @Scheduled(cron = "0 0 10,20 ? * MON")
    public void tencentUsDrama() {
        log.info("开始采集腾讯电视剧");
        Spider spider = Spider.create(new TencentPageProcessor());
        spider.addUrl("https://v.qq.com/x/cover/pgd7q0o4xlhe3r8/b0029shkvvr.html");
        spider.addPipeline(tencentPipeline);
        spider.setExitWhenComplete(true);
        spider.start();
    }

}