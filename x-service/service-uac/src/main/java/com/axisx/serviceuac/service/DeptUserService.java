package com.axisx.serviceuac.service;

import com.axisx.apiuac.dto.DeptUserDTO;

public interface DeptUserService {
    /**
     * 添加部门用户
     * @param deptUserDTO
     * @return
     */
    Boolean saveDeptUser(DeptUserDTO deptUserDTO);
}
