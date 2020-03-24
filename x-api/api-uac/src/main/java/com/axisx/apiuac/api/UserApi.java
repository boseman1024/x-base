package com.axisx.apiuac.api;

import com.axisx.apicommon.dto.ResponseDTO;
import com.axisx.apiuac.dto.*;
import org.springframework.web.bind.annotation.*;

/**
 * @author Axisx
 */
@RequestMapping("/user")
public interface UserApi {

    /**
     * 获取当前用户信息（携带权限等信息）
     * @return 当前用户信息
     */
    @GetMapping("/current")
    ResponseDTO getCurrent();

    /**
     * 获取指定用户信息（携带权限等信息）
     * @param username
     * @return
     */
    @GetMapping("/detail/{username}")
    ResponseDTO<UserDetailDTO> getUserDetail(@PathVariable("username") String username);

    /**
     * 通过ID查询用户信息
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    ResponseDTO getUser(@PathVariable("id") Integer id);

    /**
     * 查询用户列表
     * @param request
     * @return
     */
    @PostMapping("/list")
    ResponseDTO listUser(@RequestBody ListUserDTO request);

    /**
     * 添加用户
     * @param request
     * @return
     */
    @PostMapping("/save")
    ResponseDTO saveUser(@RequestBody SaveUserDTO request);

    /**
     * 删除用户
     * @param id
     * @return
     */
    @GetMapping("/remove/{id}")
    ResponseDTO removeUser(@PathVariable("id") Integer id);

    /**
     * 修改用户信息
     * @param request
     * @return
     */
    @PostMapping("/update")
    ResponseDTO updateUser(@RequestBody UpdateUserDTO request);

    /**
     * 检查用户名
     * @param username
     * @return
     */
    @GetMapping("/check/{username}")
    ResponseDTO checkUsername(@PathVariable("username") String username);
}
