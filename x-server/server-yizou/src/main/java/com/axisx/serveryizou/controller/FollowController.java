package com.axisx.serveryizou.controller;

import com.axisx.apicommon.dto.ResponseDTO;
import com.axisx.apiyizou.api.FollowApi;
import com.axisx.apiyizou.dto.ListFollowDTO;
import com.axisx.apiyizou.dto.SaveFollowDTO;
import com.axisx.apiyizou.vo.FollowVO;
import com.axisx.serviceyizou.serivce.FollowService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FollowController implements FollowApi {

    @Autowired
    FollowService followService;

    @Override
    public ResponseDTO<IPage<FollowVO>> listFollow(ListFollowDTO request) {
        return ResponseDTO.success(followService.listFollow(request));
    }

    @Override
    public ResponseDTO<Boolean> saveOrRemoveFollow(SaveFollowDTO request) {
        return ResponseDTO.success(followService.saveOrRemoveFollow(request.getFromUserId(), request.getToUserId()));
    }
}
