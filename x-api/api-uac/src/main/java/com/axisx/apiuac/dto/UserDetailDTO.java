package com.axisx.apiuac.dto;

import com.axisx.apiuac.entity.SysMenu;
import com.axisx.apiuac.entity.SysRole;
import com.axisx.apiuac.entity.SysUser;
import com.axisx.apiuac.vo.DeptVO;
import com.axisx.apiuac.vo.MenuVO;
import com.axisx.apiuac.vo.RoleVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Axisx
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailDTO{
    private SysUser sysUser;

    private Integer[] roles;

    private String[] menus;

    private List<RoleVO> roleList;

    private List<MenuVO> menuList;

    private DeptVO dept;
}
