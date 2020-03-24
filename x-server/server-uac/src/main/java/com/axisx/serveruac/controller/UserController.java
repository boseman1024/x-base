package com.axisx.serveruac.controller;

import com.axisx.apicommon.dto.ResponseDTO;
import com.axisx.apiuac.api.UserApi;
import com.axisx.apiuac.dto.*;
import com.axisx.serviceuac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Axisx
 */
@RestController
public class UserController implements UserApi {

    @Autowired
    private UserService userService;

    @Override
    public ResponseDTO getCurrent() {
        return ResponseDTO.success(userService.getCurrent());
    }

    @Override
    public ResponseDTO<UserDetailDTO> getUserDetail(String username) {
        return ResponseDTO.success(userService.getUserDetail(username));
    }

    @Override
    public ResponseDTO getUser(Integer id) {
        return ResponseDTO.success(userService.getUser(id));
    }

    @Override
    public ResponseDTO listUser(ListUserDTO request) {
        return ResponseDTO.success(userService.listUser(request));
    }

    @Override
    public ResponseDTO saveUser(SaveUserDTO request) {
        return ResponseDTO.success(userService.saveUser(request));
    }

    @Override
    public ResponseDTO removeUser(Integer id) {
        return ResponseDTO.success(userService.removeUser(id));
    }

    @Override
    public ResponseDTO updateUser(UpdateUserDTO request) {
        return ResponseDTO.success(userService.updateUser(request));
    }

    @Override
    public ResponseDTO checkUsername(String username) {
        return ResponseDTO.success(userService.checkUsername(username));
    }
}
