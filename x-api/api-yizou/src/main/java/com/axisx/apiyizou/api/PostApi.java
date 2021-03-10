package com.axisx.apiyizou.api;

import com.axisx.apicommon.dto.ResponseDTO;
import com.axisx.apiyizou.dto.ListPostDTO;
import com.axisx.apiyizou.dto.SavePostDTO;
import com.axisx.apiyizou.dto.SavePostLikeDTO;
import com.axisx.apiyizou.vo.PostVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/post")
public interface PostApi {
    /**
     * 查询列表
     * @param request
     * @return
     */
    @PostMapping("/list")
    ResponseDTO<IPage<PostVO>> listPost(@RequestBody ListPostDTO request);

    /**
     * 查询关注动态列表
     * @param request
     * @return
     */
    @PostMapping("/listFollow")
    ResponseDTO<IPage<PostVO>> listFollowPost(@RequestBody ListPostDTO request);

    /**
     * 添加
     * @param request
     * @return
     */
    @PostMapping("/save")
    ResponseDTO<Boolean> savePost(@RequestBody SavePostDTO request);

    /**
     * 删除
     * @param id
     * @return
     */
    @GetMapping("/remove/{id}")
    ResponseDTO<Boolean> removePost(@PathVariable("id") Integer id);

    /**
     * 喜欢开关
     * @param request
     * @return
     */
    @PostMapping("/like")
    ResponseDTO<Boolean> saveOrRemoveLike(@RequestBody SavePostLikeDTO request);

}
