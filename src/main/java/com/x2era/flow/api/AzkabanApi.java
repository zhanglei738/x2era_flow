package com.x2era.flow.api;

import net.sf.json.JSONObject;
import java.util.Map;

/**
 * Created on 2019/9/11 9:58 AM
 * azkaban流程执行API接口
 *
 * @author shuke
 * @version 0.1
 **/
public interface AzkabanApi {

    /***
     * 登陆API
     */
    //JSONObject login(Map<String,String> map) throws  Exception;
    /**
     *
     * */
    String login(Integer env) ;

    /***
     * 流程执行一个flow
     */
    JSONObject fetchEXEaFlow(Map<String,String> map);

    /***
     * 获取flow 信息
     *
     */
     JSONObject fetchFlowInfo(Map<String,String> map);

    /***
     *
     * 获取flow log
     */
    JSONObject fetchFlowLog(Map<String,String> map);

    /***
     * 执行流程
     */
    JSONObject fetchFlow(Map<String,String> map) throws Exception;





}