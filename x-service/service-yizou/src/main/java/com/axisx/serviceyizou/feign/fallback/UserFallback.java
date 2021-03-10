package com.axisx.serviceyizou.feign.fallback;

import com.axisx.apicommon.dto.ResponseDTO;
import com.axisx.apiuac.vo.UserVO;
import com.axisx.serviceyizou.feign.UserRemoteService;
import org.springframework.stereotype.Component;

@Component
public class UserFallback implements UserRemoteService {
    @Override
    public ResponseDTO<UserVO> getUser(Integer id) {
        return ResponseDTO.error("请求失败",null);
    }
}
