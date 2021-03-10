package com.axisx.apiyizou.api;

import com.axisx.apicommon.dto.ResponseDTO;
import com.axisx.apiyizou.dto.ListCommentDTO;
import com.axisx.apiyizou.dto.SaveCommentDTO;
import com.axisx.apiyizou.vo.CommentVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/comment")
public interface CommentApi {
    /**
     * 查询列表
     * @param request
     * @return
     */
    @PostMapping("/list")
    ResponseDTO<IPage<CommentVO>> listComment(@RequestBody ListCommentDTO request);

    /**
     * 添加
     * @param request
     * @return
     */
    @PostMapping("/save")
    ResponseDTO<Boolean> saveComment(@RequestBody SaveCommentDTO request);

    /**
     * 删除
     * @param id
     * @return
     */
    @GetMapping("/remove/{id}")
    ResponseDTO<Boolean> removeComment(@PathVariable("id") Integer id);
}
