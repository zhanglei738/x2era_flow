package com.x2era.flow.bean;

import lombok.Data;

/**
 * Created on 2019/9/11 9:41 AM
 * azkaban 实体bean
 *
 * @author shuke
 * @version 0.1
 **/
@Data
public class AzkabanBean {

    /**
     * 任务类型实体bean
     * id=session_id
     * project_name
     * flow
     */
    private  String sessionId;
    private  String projectName;
    private  String flow;




}