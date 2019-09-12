package com.x2era.flow.service.impl;


import com.x2era.flow.bean.ResourceFile;
import com.x2era.flow.dao.ResourceFileMapper;
import com.x2era.flow.service.IResourceFileService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IResourceFileServiceImpl implements IResourceFileService {

    @Resource
    private ResourceFileMapper resourceFileMapper;


    @Override
    @Transactional
    public int insert(ResourceFile record) {
        int  res=  resourceFileMapper.insert(record);
        return res;
    }

    @Override
    public List<ResourceFile> queryResourceFileList(ResourceFile resourceFile) {
        List<ResourceFile>  resourceFiles=    resourceFileMapper.queryResourceFileList(resourceFile);
        return resourceFiles;
    }

    @Override
    public int delResourceFile(Integer id) {

        return resourceFileMapper.delResourceFile(id);
    }
}
