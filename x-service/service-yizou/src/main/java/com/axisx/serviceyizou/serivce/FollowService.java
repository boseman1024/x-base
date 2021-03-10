package com.axisx.serviceyizou.serivce;

import com.axisx.apiyizou.dto.ListFollowDTO;
import com.axisx.apiyizou.vo.FollowVO;
import com.baomidou.mybatisplus.core.metadata.IPage;


public interface FollowService {
    IPage<FollowVO> listFollow(ListFollowDTO listFollowDTO);
    Boolean saveOrRemoveFollow(Integer fromUserId,Integer toUserId);
}
