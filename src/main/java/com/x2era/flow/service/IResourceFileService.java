package com.x2era.flow.service;



import com.x2era.flow.bean.ResourceFile;

import java.util.List;

public interface IResourceFileService {

    int insert(ResourceFile record);

    List<ResourceFile> queryResourceFileList(ResourceFile resourceFile);

    int delResourceFile(Integer id);
}
