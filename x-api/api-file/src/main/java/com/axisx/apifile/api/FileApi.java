package com.axisx.apifile.api;

import com.axisx.apicommon.dto.ResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/file")
public interface FileApi {

    @PostMapping("/upload")
    ResponseDTO uploadFiles(@RequestParam("files") MultipartFile[] files);
}
