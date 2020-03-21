package com.axisx.xsecurity.util;

import com.axisx.apiuac.dto.ResponseDTO;
import com.axisx.apiuac.dto.UserDetailDTO;
import com.axisx.xsecurity.feign.UserRemoteService;
import com.axisx.xutil.util.RedisUtil;
import lombok.experimental.UtilityClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@UtilityClass
public class SecurityUtil {

    @Autowired
    private UserRemoteService userRemoteService;
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 获取Authentication
     */
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取用户详细信息
     */
    public UserDetailDTO getUserDetail() {
        Authentication authentication = getAuthentication();
        if (authentication == null) {
            return null;
        }
        Object principal = authentication.getPrincipal();
        String username = String.valueOf(principal);
        ResponseDTO<UserDetailDTO> response;
        Object temp = redisUtil.get(username);
        if(temp!=null){
            response = ResponseDTO.success((UserDetailDTO)temp);
        }else{
            response =  userRemoteService.getUserDetail(username);
        }
        if(response==null||response.getData()==null){
            return null;
        }
        return response.getData();
    }

    /**
     * 获取用户名
     */
    public String getUsername() {
        Authentication authentication = getAuthentication();
        if (authentication == null) {
            return null;
        }
        return String.valueOf(authentication.getPrincipal());
    }

}
