package com.axisx.apifile.api;

import com.axisx.apicommon.dto.ResponseDTO;
import com.axisx.apifile.dto.FileDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequestMapping("/file")
public interface FileApi {

    @PostMapping("/upload")
    ResponseDTO uploadFiles(@RequestParam("files") MultipartFile[] files);

    @PostMapping("/download")
    void downloadFiles(@RequestBody FileDTO fileDTO, HttpServletResponse response) throws IOException;

    @PostMapping("/delete")
    ResponseDTO deleteFile(@RequestBody FileDTO fileDTO);
}
