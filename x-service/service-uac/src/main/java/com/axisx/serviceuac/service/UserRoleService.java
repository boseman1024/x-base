package com.axisx.serviceuac.service;

import com.axisx.apiuac.dto.UserRoleDTO;

/**
 * @author Axisx
 */
public interface UserRoleService {

    /**
     * 添加用户角色
     * @param userRoleDTO
     * @return
     */
    Boolean saveUserRoles(UserRoleDTO userRoleDTO);
}
