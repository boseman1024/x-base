package com.axisx.serveruac.controller;

import com.axisx.apiuac.api.MenuApi;
import com.axisx.apiuac.dto.*;
import com.axisx.serviceuac.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Axisx
 */
@RestController
public class MenuController implements MenuApi {

    @Autowired
    private MenuService menuService;

    @Override
    public ResponseDTO getMenu(Integer id) {
        return ResponseDTO.success(menuService.getMenu(id));
    }

    @Override
    public ResponseDTO listMenu(ListMenuDTO request) {
        return ResponseDTO.success(menuService.listMenu(request));
    }

    @Override
    public ResponseDTO saveMenu(SaveMenuDTO request) {
        return ResponseDTO.success(menuService.saveMenu(request));
    }

    @Override
    public ResponseDTO removeMenu(Integer id) {
        return ResponseDTO.success(menuService.removeMenu(id));
    }

    @Override
    public ResponseDTO updateMenu(UpdateMenuDTO request) {
        return ResponseDTO.success(menuService.updateMenu(request));
    }

    @Override
    public ResponseDTO getMenuTree(Integer id) {
        return ResponseDTO.success(menuService.getMenuTree(id));
    }

    @Override
    public ResponseDTO getMenuCheckItem() {
        return ResponseDTO.success(menuService.getMenuCheckItem());
    }

    @Override
    public ResponseDTO checkCode(String code) {
        return ResponseDTO.success(menuService.checkCode(code));
    }
}
