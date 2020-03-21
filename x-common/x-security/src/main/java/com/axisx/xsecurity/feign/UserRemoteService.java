package com.axisx.xsecurity.feign;

import com.axisx.apiuac.dto.ResponseDTO;
import com.axisx.apiuac.dto.UserDetailDTO;
import com.axisx.xsecurity.feign.fallback.UserFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Axisx
 */
@FeignClient(name = "base-gateway",fallback = UserFallback.class)
public interface UserRemoteService {
    @GetMapping("/uac/user/detail/{username}")
    ResponseDTO<UserDetailDTO> getUserDetail(@PathVariable("username") String username);
}
