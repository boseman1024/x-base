package com.axisx.serveryizou.controller;

import com.axisx.apicommon.dto.ResponseDTO;
import com.axisx.apiyizou.api.PostApi;
import com.axisx.apiyizou.dto.ListPostDTO;
import com.axisx.apiyizou.dto.SavePostDTO;
import com.axisx.apiyizou.dto.SavePostLikeDTO;
import com.axisx.apiyizou.vo.PostVO;
import com.axisx.serviceyizou.serivce.PostService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController implements PostApi {
    @Autowired
    private PostService postService;

    @Override
    public ResponseDTO<IPage<PostVO>> listPost(ListPostDTO request) {
        return ResponseDTO.success(postService.listPost(request));
    }

    @Override
    public ResponseDTO<IPage<PostVO>> listFollowPost(ListPostDTO request) {
        return ResponseDTO.success(postService.listFollowPost(request));
    }

    @Override
    public ResponseDTO<Boolean> savePost(SavePostDTO request) {
        return ResponseDTO.success(postService.savePost(request));
    }

    @Override
    public ResponseDTO<Boolean> removePost(Integer id) {
        return ResponseDTO.success(postService.removePost(id));
    }

    @Override
    public ResponseDTO<Boolean> saveOrRemoveLike(SavePostLikeDTO request) {
        return ResponseDTO.success(postService.saveOrRemoveLike(request.getPostId(),request.getUserId()));
    }

}
