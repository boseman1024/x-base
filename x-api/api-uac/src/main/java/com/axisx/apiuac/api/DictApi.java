package com.axisx.apiuac.api;

import com.axisx.apiuac.dto.ListDictDTO;
import com.axisx.apicommon.dto.ResponseDTO;
import com.axisx.apiuac.dto.SaveDictDTO;
import com.axisx.apiuac.dto.UpdateDictDTO;
import org.springframework.web.bind.annotation.*;

/**
 * @author Axisx
 */
@RequestMapping("/dict")
public interface DictApi {
    /**
     * 通过ID查询字典信息
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    ResponseDTO getDict(@PathVariable("id") Integer id);

    /**
     * 查询字典列表
     * @param request
     * @return
     */
    @PostMapping("/list")
    ResponseDTO listDict(@RequestBody ListDictDTO request);

    /**
     * 添加字典
     * @param request
     * @return
     */
    @PostMapping("/save")
    ResponseDTO saveDict(@RequestBody SaveDictDTO request);

    /**
     * 删除字典
     * @param id
     * @return
     */
    @GetMapping("/remove/{id}")
    ResponseDTO removeDict(@PathVariable("id") Integer id);

    /**
     * 修改字典信息
     * @param request
     * @return
     */
    @PostMapping("/update")
    ResponseDTO updateDict(@RequestBody UpdateDictDTO request);

    /**
     * 构造字典树
     * @param id
     * @return
     */
    @GetMapping("/tree/{id}")
    ResponseDTO getDictTree(@PathVariable("id") Integer id);

    /**
     * 获取字典子集
     * @param code
     * @return
     */
    @PostMapping("/getChild/{code}")
    ResponseDTO getDictChild(@PathVariable("code") String code);

    /**
     * 检查字典标志
     * @param code
     * @return
     */
    @GetMapping("/check/{code}")
    ResponseDTO checkCode(@PathVariable("code") String code);
}
