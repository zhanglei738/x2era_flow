package com.x2era.flow.dao;

import com.x2era.flow.bean.ResourceFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResourceFileMapper {
    int deleteByPrimaryKey(Integer resourceId);

    int insert(ResourceFile record);

    int insertSelective(ResourceFile record);

    ResourceFile selectByPrimaryKey(Integer resourceId);

    int updateByPrimaryKeySelective(ResourceFile record);

    int updateByPrimaryKey(ResourceFile record);

    List<ResourceFile>  queryResourceFileList(ResourceFile resourceFile);

    int delResourceFile(Integer id);
}