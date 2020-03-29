package com.axisx.serverworkflow.controller;

import com.axisx.apicommon.dto.ResponseDTO;
import com.axisx.apiworkflow.api.ProcessApi;
import com.axisx.apiworkflow.dto.ListProcessDTO;
import com.axisx.serviceworkflow.service.ProcessService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProcessController implements ProcessApi {

    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private ProcessService processService;

    @Override
    public ResponseDTO start(String id) {
        ProcessInstance instance = runtimeService.startProcessInstanceById(id);
        if(instance==null){
            return ResponseDTO.error("该流程不存在",false);
        }
        return ResponseDTO.success("流程开始",true);
    }

    @Override
    public ResponseDTO list(ListProcessDTO listProcessDTO) {
        return ResponseDTO.success(processService.list(listProcessDTO));
    }


}
