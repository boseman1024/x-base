package com.axisx.serviceyizou.serivce;

import com.axisx.apiyizou.dto.ListPostDTO;
import com.axisx.apiyizou.dto.SavePostDTO;
import com.axisx.apiyizou.vo.PostVO;
import com.baomidou.mybatisplus.core.metadata.IPage;

public interface PostService {
    IPage<PostVO> listPost(ListPostDTO listPosterDTO);

    IPage<PostVO> listFollowPost(ListPostDTO listPosterDTO);

    Boolean savePost(SavePostDTO savePosterDTO);

    Boolean removePost(Integer id);

    Boolean saveOrRemoveLike(Integer postId,Integer userId);

}
