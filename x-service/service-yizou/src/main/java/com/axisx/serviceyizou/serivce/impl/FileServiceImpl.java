package com.axisx.serviceyizou.serivce.impl;

import com.axisx.apiyizou.dto.SaveFileDTO;
import com.axisx.apiyizou.entity.YizouFile;
import com.axisx.apiyizou.entity.YizouPostFile;
import com.axisx.serviceyizou.dao.FileMapper;
import com.axisx.serviceyizou.dao.PostFileMapper;
import com.axisx.serviceyizou.serivce.FileService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, YizouFile> implements FileService {

    private BeanCopier beanCopier;
    private YizouFile yizouFile;
    @Autowired
    private PostFileMapper postFileMapper;

    @Override
    public List<YizouFile> listByPosterId(Integer posterId) {
        List<Integer> ids = postFileMapper
                .selectList(
                        Wrappers.<YizouPostFile>lambdaQuery()
                        .eq(YizouPostFile::getPostId,posterId)
                ).stream()
                .map(YizouPostFile::getFileId)
                .collect(Collectors.toList());
        if(ids.size()==0){
            return null;
        }
        return this.listByIds(ids);
    }

    @Override
    public Boolean removerByPosterId(Integer posterId) {
        List<Integer> ids = postFileMapper
                .selectList(
                        Wrappers.<YizouPostFile>lambdaQuery()
                        .eq(YizouPostFile::getPostId,posterId)
                )
                .stream()
                .map(YizouPostFile::getFileId)
                .collect(Collectors.toList());
        if(ids.size()==0){
            return true;
        }
        this.removeByIds(ids);
        postFileMapper.deleteBatchIds(ids);
        return true;
    }

    @Override
    public Integer save(SaveFileDTO saveFileDTO) {
        beanCopier = BeanCopier.create(SaveFileDTO.class, YizouFile.class,false);
        yizouFile = new YizouFile();
        beanCopier.copy(saveFileDTO,yizouFile,null);
        this.save(yizouFile);
        return yizouFile.getId();
    }
}
