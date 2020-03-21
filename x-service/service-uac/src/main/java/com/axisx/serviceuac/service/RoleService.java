package com.axisx.serviceuac.service;

import com.axisx.apiuac.dto.*;
import com.axisx.apiuac.vo.RoleVO;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * @author Axisx
 */
public interface RoleService {

    List<RoleVO> listRoleByUserId(Integer id);

    RoleVO getRole(Integer id);

    IPage<RoleVO> listRolePage(ListRoleDTO listRoleDTO);

    List<RoleVO> listRole(ListRoleDTO listRoleDTO);

    RoleVO saveRole(SaveRoleDTO saveRoleDTO);

    Boolean removeRole(Integer id);

    RoleVO updateRole(UpdateRoleDTO updateRoleDTO);

    Boolean checkCode(String code);

}
