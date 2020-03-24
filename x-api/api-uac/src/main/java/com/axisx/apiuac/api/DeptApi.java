package com.axisx.apiuac.api;

import com.axisx.apicommon.dto.ResponseDTO;
import com.axisx.apiuac.dto.*;
import org.springframework.web.bind.annotation.*;

/**
 * @author Axisx
 */
@RequestMapping("/dept")
public interface DeptApi {
    /**
     * 通过ID查询部门信息
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    ResponseDTO getDept(@PathVariable("id") Integer id);

    /**
     * 查询部门列表
     * @param request
     * @return
     */
    @PostMapping("/list")
    ResponseDTO listDept(@RequestBody ListDeptDTO request);

    /**
     * 添加部门
     * @param request
     * @return
     */
    @PostMapping("/save")
    ResponseDTO saveDept(@RequestBody SaveDeptDTO request);

    /**
     * 删除部门
     * @param id
     * @return
     */
    @GetMapping("/remove/{id}")
    ResponseDTO removeDept(@PathVariable("id") Integer id);

    /**
     * 修改部门信息
     * @param request
     * @return
     */
    @PostMapping("/update")
    ResponseDTO updateDept(@RequestBody UpdateDeptDTO request);

    /**
     * 构造部门树
     * @param id
     * @return
     */
    @GetMapping("/tree/{id}")
    ResponseDTO getDeptTree(@PathVariable("id") Integer id);
}
