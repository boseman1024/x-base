package com.axisx.xsecurity.feign.fallback;

import com.axisx.apiuac.dto.ResponseDTO;
import com.axisx.apiuac.dto.UserDetailDTO;
import com.axisx.xsecurity.feign.UserRemoteService;
import org.springframework.stereotype.Component;

@Component
public class UserFallback implements UserRemoteService {
    @Override
    public ResponseDTO<UserDetailDTO> getUserDetail(String username) {
        return ResponseDTO.error("请求失败");
    }
}
