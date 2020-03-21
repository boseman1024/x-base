package com.axisx.serviceuac.service.impl;

import com.axisx.apiuac.dto.UserRoleDTO;
import com.axisx.apiuac.entity.SysUserRole;
import com.axisx.serviceuac.dao.UserRoleMapper;
import com.axisx.serviceuac.service.UserRoleService;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Axisx
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, SysUserRole> implements UserRoleService {
    @Override
    public Boolean saveUserRoles(UserRoleDTO userRoleDTO) {
        String roleIds = userRoleDTO.getRoleIds();
        Integer userId = userRoleDTO.getUserId();
        this.remove(Wrappers.<SysUserRole>lambdaUpdate().eq(SysUserRole::getUserId,userId));
        if(StringUtils.isBlank(roleIds)){
            return false;
        }
        String[] roleIdArr = roleIds.split(",");
        List<SysUserRole> sysUserRoleList = new ArrayList<>();
        for(String role : roleIdArr){
            SysUserRole sysUserRole = new SysUserRole(userId,Integer.valueOf(role));
            sysUserRoleList.add(sysUserRole);
        }
        return this.saveBatch(sysUserRoleList);
    }
}
