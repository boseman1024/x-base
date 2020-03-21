package com.axisx.serviceuac.service.impl;

import com.axisx.apiuac.dto.RoleMenuDTO;
import com.axisx.apiuac.entity.SysRoleMenu;
import com.axisx.serviceuac.dao.RoleMenuMapper;
import com.axisx.serviceuac.service.RoleMenuService;
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
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, SysRoleMenu> implements RoleMenuService {
    @Override
    public Boolean saveRoleMenus(RoleMenuDTO roleMenuDTO) {
        String menuIds = roleMenuDTO.getMenuIds();
        Integer roleId = roleMenuDTO.getRoleId();
        this.remove(Wrappers.<SysRoleMenu>lambdaUpdate().eq(SysRoleMenu::getRoleId,roleId));
        if(StringUtils.isBlank(menuIds)){
            return false;
        }
        String[] menuIdArr = menuIds.split(",");
        List<SysRoleMenu> sysRoleMenuList = new ArrayList<>();
        for(String menu : menuIdArr){
            SysRoleMenu sysRoleMenu = new SysRoleMenu(roleId,Integer.valueOf(menu));
            sysRoleMenuList.add(sysRoleMenu);
        }
        return this.saveBatch(sysRoleMenuList);
    }
}
