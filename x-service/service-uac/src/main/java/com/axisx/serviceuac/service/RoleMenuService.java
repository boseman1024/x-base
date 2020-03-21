package com.axisx.serviceuac.service;

import com.axisx.apiuac.dto.RoleMenuDTO;

/**
 * @author Axisx
 */
public interface RoleMenuService {
    /**
     * 添加角色资源
     * @param roleMenuDTO
     * @return
     */
    Boolean saveRoleMenus(RoleMenuDTO roleMenuDTO);
}
