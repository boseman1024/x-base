package com.axisx.serviceyizou.dao;

import com.axisx.apiyizou.entity.YizouFollow;
import com.axisx.apiyizou.entity.YizouPost;
import com.axisx.apiyizou.vo.FollowVO;
import com.axisx.apiyizou.vo.PostVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FollowMapper extends BaseMapper<YizouFollow> {
    /**
     * 模糊查询列表(分页)
     * @param page
     * @param yizouFollow
     * @return
     */
    @Select("<script>" +
            "select id,from_user_id,to_user_id " +
            "from yizou_follow " +
            "<where> 1=1 " +
            "<if test='follow.fromUserId!=null'>" +
            "and from_user_id = #{follow.fromUserId} " +
            "</if>" +
            "<if test='follow.toUserId!=null'>" +
            "and to_user_id = #{follow.toUserId} " +
            "</if>" +
            "</where>" +
            "</script>")
    IPage<FollowVO> listFollow(IPage<FollowVO> page, @Param("follow") YizouFollow yizouFollow);
}
