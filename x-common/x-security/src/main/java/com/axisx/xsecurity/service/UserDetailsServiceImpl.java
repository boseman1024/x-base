package com.axisx.xsecurity.service;

import com.axisx.apiuac.dto.ResponseDTO;
import com.axisx.apiuac.dto.UserDetailDTO;
import com.axisx.apiuac.entity.SysUser;
import com.axisx.xsecurity.feign.UserRemoteService;
import com.axisx.xsecurity.model.OauthUser;
import com.axisx.xutil.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Axisx
 */
@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRemoteService userRemoteService;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("用户信息读取");
        ResponseDTO<UserDetailDTO> response;
        Object temp = redisUtil.get(username);
        if(temp!=null){
            log.info("缓存读取");
            response = ResponseDTO.success((UserDetailDTO)temp);
        }else{
            log.info("数据库读取");
            response =  userRemoteService.getUserDetail(username);
            redisUtil.set(username,response.getData(),Long.valueOf(60*60*1000));
        }
        return getOauthUser(response);
    }

    public OauthUser getOauthUser(ResponseDTO<UserDetailDTO> response){
        if(response==null||response.getData()==null){
            log.info("异常："+response.getMsg());
            throw  new UsernameNotFoundException("用户不存在");
        }
        UserDetailDTO userDetailDTO = response.getData();
        Set<String> menuSet = new HashSet<>();
        if (userDetailDTO.getRoles()!=null&&userDetailDTO.getRoles().length>0) {
            // 获取角色
            Arrays.stream(userDetailDTO.getRoles()).forEach(role -> menuSet.add("ROLE_"+role));
            // 获取资源
            menuSet.addAll(Arrays.asList(userDetailDTO.getMenus()));
        }
        Collection<? extends GrantedAuthority> authorities
                = AuthorityUtils.createAuthorityList(menuSet.toArray(new String[0]));
        SysUser user = userDetailDTO.getSysUser();
        User userDetail = new User(user.getUsername(),user.getPassword(),authorities);
        return new OauthUser(userDetailDTO,userDetail);
    }
}
