package com.x2era.flow.api.impl;


import com.x2era.flow.api.AzkabanApi;
import com.x2era.flow.common.ConfigInfo;
import com.x2era.flow.common.SSLUtil;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

/**
 * Created on 2019/9/11 10:30 AM
 *
 * @author shuke
 * @version 0.1
 **/
@Service("azkabanApi")
@Slf4j
public class AzkabanApiImp implements AzkabanApi {

    private RestTemplate restTemplate;
    private HttpHeaders httpHeaders;

    /**
     * 请求参数方法
     * 需要跳过SSL认证
     */

    private void before() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(2000);
        requestFactory.setReadTimeout(2000);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        httpHeaders.add("X-Requested-With", "XMLHttpRequest");
        httpHeaders.add("Accept", "text/plain;charset=utf-8");
    }

    /**
     * 需要跳过SSL认证
     */

//    @Override
//    public JSONObject login(Map<String, String> map) throws Exception {
//        //请求头
//        before();
//        //跳过SSL认证
//        SSLUtil.turnOffSslChecking();
//        //登陆
//        LinkedMultiValueMap<String,String> linkedMultiValueMap = new LinkedMultiValueMap<String,String>();
//        linkedMultiValueMap.add("action","login");
//        linkedMultiValueMap.add("username", ConfigInfo.USERNAME);
//        linkedMultiValueMap.add("password",ConfigInfo.PASSWORD);
//        HttpEntity<LinkedMultiValueMap<String, String>> httpEntity = new HttpEntity<>(linkedMultiValueMap, httpHeaders);
//        JSONObject postForObject = restTemplate.postForObject(ConfigInfo.URL,httpEntity,JSONObject.class);
//        return postForObject;
//        return  null;
//    }

    @Override
    public JSONObject login() throws Exception {
        //请求头
        before();
        //跳过SSL认证
        SSLUtil.turnOffSslChecking();
        //登陆
        LinkedMultiValueMap<String,String> linkedMultiValueMap = new LinkedMultiValueMap<String,String>();
        linkedMultiValueMap.add("action","login");
        linkedMultiValueMap.add("username", ConfigInfo.USERNAME);
        linkedMultiValueMap.add("password",ConfigInfo.PASSWORD);
        HttpEntity<LinkedMultiValueMap<String, String>> httpEntity = new HttpEntity<>(linkedMultiValueMap, httpHeaders);
        JSONObject postForObject = restTemplate.postForObject(ConfigInfo.URL,httpEntity,JSONObject.class);
        return postForObject;
    }

    @Override
    public JSONObject fetchEXEaFlow(Map<String,String> map) {
        before();
        SSLUtil.turnOffSslChecking();
        /**
         * map 测试用
         */
//
//        HashMap<String, String> map = Maps.newHashMap();
//        map.put("session-id","");
//        map.put("project","");
//        map.put("flow","");

        StringBuffer buffer = new StringBuffer();
        for (Map.Entry<String,String> entry: map.entrySet()) {
            buffer.append("&"+entry.getKey()+"="+entry.getValue());
        }

        JSONObject postObject = null;
        /**
         * 重试三次，获取日志,预留功能
         * */
        for (int i = 0; i < 3; i++){
            try {
                ResponseEntity<String> exchange =
                        restTemplate.exchange(map.get("address") + "/executor?session.id={id}&ajax=executeFlow&project={project}&flow={flow}"+buffer, HttpMethod.GET,
                                new HttpEntity<String>(httpHeaders), String.class, map);

                log.info(exchange.getBody());
                postObject = JSONObject.fromObject(exchange.getBody());
                //如果postObject 存在直接返回
                if(!StringUtils.isEmpty(postObject)){
                    break;
                }
              Thread.sleep(1000);
            }catch (Exception e){
                log.error("azkaban日志获取失败",e.getMessage(),e);
            }
        }

        return postObject;
    }
}