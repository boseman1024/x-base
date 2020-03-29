package com.axisx.apiworkflow.api;

import com.axisx.apicommon.dto.ResponseDTO;
import com.axisx.apiworkflow.dto.ListProcessDTO;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/process")
public interface ProcessApi {

    /**
     * 通过ID开始流程
     * @param id
     * @return
     */
    @GetMapping("/start/{id}")
    ResponseDTO start(@PathVariable("id") String id);

    /**
     * 分页查询所有流程
     * @return
     */
    @PostMapping("/list")
    ResponseDTO list( @RequestBody ListProcessDTO listProcessDTO);


}
