package com.axisx.serveruac.controller;

import com.axisx.apicommon.dto.ResponseDTO;
import com.axisx.apiuac.api.DeptApi;
import com.axisx.apiuac.dto.*;
import com.axisx.serviceuac.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Axisx
 */
@RestController
public class DeptController implements DeptApi {

    @Autowired
    private DeptService deptService;

    @Override
    public ResponseDTO getDept(Integer id) {
        return ResponseDTO.success(deptService.getDept(id));
    }

    @Override
    public ResponseDTO listDept(ListDeptDTO request) {
        return ResponseDTO.success(deptService.listDept(request));
    }

    @Override
    public ResponseDTO saveDept(SaveDeptDTO request) {
        return ResponseDTO.success(deptService.saveDept(request));
    }

    @Override
    public ResponseDTO removeDept(Integer id) {
        return ResponseDTO.success(deptService.removeDept(id));
    }

    @Override
    public ResponseDTO updateDept(UpdateDeptDTO request) {
        return ResponseDTO.success(deptService.updateDept(request));
    }

    @Override
    public ResponseDTO getDeptTree(Integer id) {
        return ResponseDTO.success(deptService.getDeptTree(id));
    }
}
