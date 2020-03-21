package com.axisx.serviceuac.service.impl;

import com.axisx.apiuac.dto.DeptMenuDTO;
import com.axisx.apiuac.entity.SysDeptMenu;
import com.axisx.serviceuac.dao.DeptMenuMapper;
import com.axisx.serviceuac.service.DeptMenuService;
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
public class DeptMenuServiceImpl extends ServiceImpl<DeptMenuMapper,SysDeptMenu> implements DeptMenuService {
    @Override
    public Boolean saveDeptMenus(DeptMenuDTO deptMenuDTO) {
        String menuIds = deptMenuDTO.getMenuIds();
        Integer deptId = deptMenuDTO.getDeptId();
        this.remove(Wrappers.<SysDeptMenu>lambdaUpdate().eq(SysDeptMenu::getDeptId,deptId));
        if(StringUtils.isBlank(menuIds)){
            return false;
        }
        String[] menuIdArr = menuIds.split(",");
        List<SysDeptMenu> sysDeptMenuList = new ArrayList<>();
        for(String menu : menuIdArr){
            SysDeptMenu sysRoleMenu = new SysDeptMenu(deptId,Integer.valueOf(menu));
            sysDeptMenuList.add(sysRoleMenu);
        }
        return this.saveBatch(sysDeptMenuList);
    }
}
