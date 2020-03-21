package com.axisx.serviceuac.service;

import com.axisx.apiuac.dto.DeptMenuDTO;

/**
 * @author Axisx
 */
public interface DeptMenuService {
    /**
     * 添加部门资源
     * @param deptMenuDTO
     * @return
     */
    Boolean saveDeptMenus(DeptMenuDTO deptMenuDTO);
}
