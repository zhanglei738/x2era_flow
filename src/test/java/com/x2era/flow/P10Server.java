package com.x2era.flow;

import com.x2era.flow.utils.RuntimeUtils;
import org.slf4j.LoggerFactory;

public class P10Server {
    final org.slf4j.Logger log = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        System.out.println("启动p10服务:init....");
        String command = "sh startup.sh";
        String dir=RuntimeUtils.class.getResource("/").getPath()+"KTServer";
        System.out.println(dir);
        try {
            RuntimeUtils.exec(command);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}