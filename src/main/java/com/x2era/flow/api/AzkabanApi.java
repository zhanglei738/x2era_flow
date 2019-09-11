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
    JSONObject login() throws  Exception;

    /***
     * 流程执行API
     */
    JSONObject fetchEXEaFlow(Map<String,String> map);



}