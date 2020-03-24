package com.axisx.apiuac.api;

import com.axisx.apicommon.dto.ResponseDTO;
import com.axisx.apiuac.dto.*;
import org.springframework.web.bind.annotation.*;

/**
 * @author Axisx
 */
@RequestMapping("/menu")
public interface MenuApi {

    /**
     * 通过ID查询资源信息
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    ResponseDTO getMenu(@PathVariable("id") Integer id);

    /**
     * 查询资源列表
     * @param request
     * @return
     */
    @PostMapping("/list")
    ResponseDTO listMenu(@RequestBody ListMenuDTO request);

    /**
     * 添加资源
     * @param request
     * @return
     */
    @PostMapping("/save")
    ResponseDTO saveMenu(@RequestBody SaveMenuDTO request);

    /**
     * 删除资源
     * @param id
     * @return
     */
    @GetMapping("/remove/{id}")
    ResponseDTO removeMenu(@PathVariable("id")Integer id);

    /**
     * 修改资源信息
     * @param request
     * @return
     */
    @PostMapping("/update")
    ResponseDTO updateMenu(@RequestBody UpdateMenuDTO request);

    /**
     * 构造资源树
     * @param id
     * @return
     */
    @GetMapping("/tree/{id}")
    ResponseDTO getMenuTree(@PathVariable("id") Integer id);

    /**
     * 构造资源组
     * @return
     */
    @GetMapping("/items")
    ResponseDTO getMenuCheckItem();

    /**
     * 检查资源标志
     * @param code
     * @return
     */
    @GetMapping("/check/{code}")
    ResponseDTO checkCode(@PathVariable("code") String code);
}
