package com.axisx.serveruac.controller;

import com.axisx.apiuac.api.DictApi;
import com.axisx.apiuac.dto.*;
import com.axisx.serviceuac.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Axisx
 */
@RestController
public class DictController implements DictApi {

    @Autowired
    private DictService dictService;

    @Override
    public ResponseDTO getDict(Integer id) {
        return ResponseDTO.success(dictService.getDict(id));
    }

    @Override
    public ResponseDTO listDict(ListDictDTO request) {
        return ResponseDTO.success(dictService.listDict(request));
    }

    @Override
    public ResponseDTO saveDict(SaveDictDTO request) {
        return ResponseDTO.success(dictService.saveDict(request));
    }

    @Override
    public ResponseDTO removeDict(Integer id) {
        return ResponseDTO.success(dictService.removeDict(id));
    }

    @Override
    public ResponseDTO updateDict(UpdateDictDTO request) {
        return ResponseDTO.success(dictService.updateDict(request));
    }

    @Override
    public ResponseDTO getDictTree(Integer id) {
        return ResponseDTO.success(dictService.getDictTree(id));
    }

    @Override
    public ResponseDTO getDictChild(String code) {
        return ResponseDTO.success(dictService.getChild(code));
    }

    @Override
    public ResponseDTO checkCode(String code) {
        return ResponseDTO.success(dictService.checkCode(code));
    }
}
