package com.axisx.apiyizou.api;

import com.axisx.apicommon.dto.ResponseDTO;
import com.axisx.apiyizou.dto.ListPosterDTO;
import com.axisx.apiyizou.dto.SavePosterDTO;
import com.axisx.apiyizou.dto.UpdatePosterDTO;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/poster")
public interface PosterApi {
    /**
     * 查询海报列表
     * @param request
     * @return
     */
    @PostMapping("/list")
    ResponseDTO listPosters(@RequestBody ListPosterDTO request);

    /**
     * 添加海报
     * @param request
     * @return
     */
    @PostMapping("/save")
    ResponseDTO savePoster(@RequestBody SavePosterDTO request);

    /**
     * 删除海报
     * @param id
     * @return
     */
    @GetMapping("/remove/{id}")
    ResponseDTO removePoster(@PathVariable("id") Integer id);

    /**
     * 修改海报信息
     * @param request
     * @return
     */
    @PostMapping("/update")
    ResponseDTO updatePoster(@RequestBody UpdatePosterDTO request);
}
