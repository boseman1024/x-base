package com.axisx.serverfile.controller;

import com.axisx.apifile.api.FileApi;
import com.axisx.apicommon.dto.ResponseDTO;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.exception.FdfsConnectException;
import com.github.tobato.fastdfs.service.AppendFileStorageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author axisx
 */
@RestController
public class FileController implements FileApi {

    @Autowired
    public AppendFileStorageClient appendFileStorageClient;

    @Override
    public ResponseDTO uploadFiles(MultipartFile[] files) {
        List<StorePath> storePathList = new ArrayList<>();
        try{
            for(MultipartFile file : files){
                StorePath storePath = appendFileStorageClient.uploadFile("group1",file.getInputStream(),file.getSize(),file.getContentType());
                storePathList.add(storePath);
            }
            return ResponseDTO.success("上传成功",storePathList);
        }catch (IOException e) {
            e.printStackTrace();
            for(StorePath storePath : storePathList){
                appendFileStorageClient.deleteFile(storePath.getGroup(),storePath.getPath());
            }
            return ResponseDTO.error("上传失败");
        }catch (FdfsConnectException e) {
            e.printStackTrace();
            return ResponseDTO.error("无法连接文件服务器");
        }
    }
}
