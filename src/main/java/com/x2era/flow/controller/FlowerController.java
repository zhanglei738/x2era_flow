package com.x2era.flow.controller;

import com.x2era.flow.api.impl.AzkabanApiImp;
import com.x2era.flow.bean.AzkabanBean;
import com.x2era.flow.common.RestResult;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2019/9/11 12:07 PM
 * 流程控制接口
 *
 * @author shuke
 * @version 0.1
 **/

@Slf4j
@RestController
@RequestMapping("/flow")
public class FlowerController {
    @Autowired
    private AzkabanApiImp azkabanApi;


    /***
     * TODO。。。 接口设计具体传参
     */
     //任务执行流程
    @RequestMapping(value = "/execFlow", method = RequestMethod.GET)
    public RestResult fetchEXEaFlow(AzkabanBean azkaban)  {
        //先登陆然后拿到sessionid 在请求接口
         Map<String,String> map = new HashMap<>();
         //登陆
        JSONObject jo = null;

        // String status = jo.getString("status");
        // String sessionId = jo.getString("session.id");
        // map.put("sessionId",jo.getString("session.id"));
        // map.put("project",azkaban.getProjectName());
        map.put("flow",azkaban.getFlow());
        try {
            jo = azkabanApi.fetchFlow(map);
        } catch (Exception e) {
            log.info("流程执行失败:"+e.getMessage(),e);
        }
        return  RestResult.ok(jo.get("status").toString());
    }











}