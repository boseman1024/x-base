package com.axisx.serveryizou.controller;

import com.axisx.apicommon.dto.ResponseDTO;
import com.axisx.apiyizou.api.CommentApi;
import com.axisx.apiyizou.dto.ListCommentDTO;
import com.axisx.apiyizou.dto.SaveCommentDTO;
import com.axisx.apiyizou.vo.CommentVO;
import com.axisx.serviceyizou.serivce.CommentService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController implements CommentApi {

    @Autowired
    private CommentService commentService;

    @Override
    public ResponseDTO<IPage<CommentVO>> listComment(ListCommentDTO request) {
        return ResponseDTO.success(commentService.listComment(request));
    }

    @Override
    public ResponseDTO<Boolean> saveComment(SaveCommentDTO request) {
        return ResponseDTO.success(commentService.saveComment(request));
    }

    @Override
    public ResponseDTO<Boolean> removeComment(Integer id) {
        return ResponseDTO.success(commentService.removeComment(id));
    }
}
