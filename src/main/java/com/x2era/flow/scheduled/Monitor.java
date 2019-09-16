package com.x2era.flow.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created on 2019/9/16 11:44 AM
 * 监控程序
 *
 * @author shuke
 * @version 0.1
 **/
@Component
public class Monitor {
    /***
     * 自定义报表监控
     * select count(1) from xxx  根据数据返回来判断数据是否正常
     */
    @Scheduled(cron = "* * * 1 * ? ") // 每天执行一次
    public void countMonitor() {



    }

}