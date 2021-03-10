package com.axisx.apiyizou.api;

import com.axisx.apicommon.dto.ResponseDTO;
import com.axisx.apiyizou.dto.ListFollowDTO;
import com.axisx.apiyizou.dto.SaveFollowDTO;
import com.axisx.apiyizou.vo.FollowVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/follow")
public interface FollowApi {
    /**
     * 查询列表
     * @param request
     * @return
     */
    @PostMapping("/list")
    ResponseDTO<IPage<FollowVO>> listFollow(@RequestBody ListFollowDTO request);

    /**
     * 关注开关
     * @param request
     * @return
     */
    @PostMapping("/like")
    ResponseDTO<Boolean> saveOrRemoveFollow(@RequestBody SaveFollowDTO request);
}
