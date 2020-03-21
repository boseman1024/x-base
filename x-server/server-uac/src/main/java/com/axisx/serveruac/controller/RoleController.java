package com.axisx.serveruac.controller;

import com.axisx.apiuac.api.RoleApi;
import com.axisx.apiuac.dto.*;
import com.axisx.serviceuac.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Axisx
 */
@RestController
public class RoleController implements RoleApi {

    @Autowired
    private RoleService roleService;

    @Override
    public ResponseDTO getRole(Integer id) {
        return ResponseDTO.success(roleService.getRole(id));
    }

    @Override
    public ResponseDTO listRolePage(ListRoleDTO request) {
        return ResponseDTO.success(roleService.listRolePage(request));
    }

    @Override
    public ResponseDTO listRole(ListRoleDTO request) {
        return ResponseDTO.success(roleService.listRole(request));
    }

    @Override
    public ResponseDTO saveRole(SaveRoleDTO request) {
        return ResponseDTO.success(roleService.saveRole(request));
    }

    @Override
    public ResponseDTO removeRole(Integer id) {
        return ResponseDTO.success(roleService.removeRole(id));
    }

    @Override
    public ResponseDTO updateRole(UpdateRoleDTO request) {
        return ResponseDTO.success(roleService.updateRole(request));
    }

    @Override
    public ResponseDTO checkCode(String code) {
        return ResponseDTO.success(roleService.checkCode(code));
    }
}
