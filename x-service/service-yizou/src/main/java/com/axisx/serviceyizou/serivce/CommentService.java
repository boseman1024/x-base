package com.axisx.serviceyizou.serivce;

import com.axisx.apiyizou.dto.ListCommentDTO;
import com.axisx.apiyizou.dto.SaveCommentDTO;
import com.axisx.apiyizou.vo.CommentVO;
import com.baomidou.mybatisplus.core.metadata.IPage;

public interface CommentService {
    IPage<CommentVO> listComment(ListCommentDTO listCommentDTO);
    Boolean removeComment(Integer id);
    Boolean saveComment(SaveCommentDTO saveCommentDTO);
}
