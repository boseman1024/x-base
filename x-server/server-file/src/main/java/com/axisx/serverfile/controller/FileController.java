package com.axisx.serverfile.controller;

import com.axisx.apifile.api.FileApi;
import com.axisx.apicommon.dto.ResponseDTO;
import com.axisx.apifile.dto.FileDTO;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.domain.proto.storage.DownloadFileStream;
import com.github.tobato.fastdfs.exception.FdfsConnectException;
import com.github.tobato.fastdfs.service.AppendFileStorageClient;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.logging.Logger;

/**
 * @author axisx
 */
@RestController
public class FileController implements FileApi {

    Logger logger = Logger.getLogger("file");
    @Autowired
    private FastFileStorageClient fastFileStorageClient;
    private String[] imgTypes = new String[]{"jpg", "jpeg", "png", "gif", "bmp", "wbmp"};

    @Override
    public ResponseDTO uploadFiles(MultipartFile[] files) {
        List<StorePath> storePathList = new ArrayList<>();
        try{
            logger.info("上传文件开始");
            StorePath storePath;
            boolean isImg;
            for(MultipartFile file : files){
                logger.info("文件："+file.getOriginalFilename());
                String fileExtName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1).toLowerCase();
                isImg = Arrays.stream(imgTypes).anyMatch(type-> type.equals(fileExtName));
                logger.info("是否图片？："+isImg);
                if(isImg){
                    storePath = fastFileStorageClient.uploadImageAndCrtThumbImage(file.getInputStream(),file.getSize(),fileExtName,null);
                }else {
                    storePath =fastFileStorageClient.uploadFile(file.getInputStream(),file.getSize(),fileExtName,null);
                }
                storePathList.add(storePath);
                file.getInputStream().close();
            }
            logger.info("上传文件结束");
            return ResponseDTO.success("上传成功",storePathList);
        }catch (IOException e) {
            e.printStackTrace();
            for(StorePath storePath : storePathList){
                fastFileStorageClient.deleteFile(storePath.getGroup(),storePath.getPath());
            }
            return ResponseDTO.error("上传失败");
        }catch (FdfsConnectException e) {
            e.printStackTrace();
            return ResponseDTO.error("无法连接文件服务器");
        }
    }

    @Override
    public void downloadFiles(FileDTO fileDTO, HttpServletResponse response) throws IOException {
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            DownloadFileStream stream = new DownloadFileStream(os);
            logger.info("下载文件"+fileDTO.getPath()+"开始");
            fastFileStorageClient.downloadFile(fileDTO.getGroup(),fileDTO.getPath(), stream);
            logger.info("下载文件结束");
            os.close();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            os.close();
        }


    }

    @Override
    public ResponseDTO deleteFile(FileDTO fileDTO) {
        if(fileDTO.getGroup()!=null&&fileDTO.getPath()!=null){
            fastFileStorageClient.deleteFile(fileDTO.getFullPath());
        }
        if(fileDTO.getFullPath()!=null){
            fastFileStorageClient.deleteFile(fileDTO.getGroup(),fileDTO.getPath());
        }
        return ResponseDTO.success("删除成功");
    }
}
