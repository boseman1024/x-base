package com.axisx.apiuac.api;

import com.axisx.apiuac.dto.ListRoleDTO;
import com.axisx.apicommon.dto.ResponseDTO;
import com.axisx.apiuac.dto.SaveRoleDTO;
import com.axisx.apiuac.dto.UpdateRoleDTO;
import org.springframework.web.bind.annotation.*;

/**
 * @author Axisx
 */
@RequestMapping("/role")
public interface RoleApi {
    /**
     * 通过ID查询角色信息
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    ResponseDTO getRole(@PathVariable("id") Integer id);

    /**
     * 查询角色列表(分页)
     * @param request
     * @return
     */
    @PostMapping("/page")
    ResponseDTO listRolePage(@RequestBody ListRoleDTO request);

    /**
     * 查询角色列表
     * @param request
     * @return
     */
    @PostMapping("/list")
    ResponseDTO listRole(@RequestBody ListRoleDTO request);

    /**
     * 添加角色
     * @param request
     * @return
     */
    @PostMapping("/save")
    ResponseDTO saveRole(@RequestBody SaveRoleDTO request);

    /**
     * 删除角色
     * @param id
     * @return
     */
    @GetMapping("/remove/{id}")
    ResponseDTO removeRole(@PathVariable("id") Integer id);

    /**
     * 修改角色信息
     * @param request
     * @return
     */
    @PostMapping("/update")
    ResponseDTO updateRole(@RequestBody UpdateRoleDTO request);

    /**
     * 检查角色标志
     * @param code
     * @return
     */
    @GetMapping("/check/{code}")
    ResponseDTO checkCode(@PathVariable("code") String code);
}
