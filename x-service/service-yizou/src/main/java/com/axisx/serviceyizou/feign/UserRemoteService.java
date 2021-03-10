package com.axisx.serviceyizou.feign;

import com.axisx.apicommon.dto.ResponseDTO;
import com.axisx.apiuac.vo.UserVO;
import com.axisx.serviceyizou.feign.fallback.UserFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Axisx
 */
@FeignClient(name = "base-gateway",fallback = UserFallback.class)
public interface UserRemoteService {
    @GetMapping("/uac/user/get/{id}")
    ResponseDTO<UserVO> getUser(@PathVariable("id") Integer id);
}
