package com.axisx.serviceyizou.dao;

import com.axisx.apiyizou.entity.YizouPost;
import com.axisx.apiyizou.vo.PostVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostMapper extends BaseMapper<YizouPost> {
    /**
     * 模糊查询列表(分页)
     * @param page
     * @param yizouPost
     * @return
     */
    @Select("<script>" +
            "select id,location,creator_id,content,create_time,del_flag " +
            "from yizou_post " +
            "<where> 1=1 " +
            "<if test='ids!=null'>" +
            "and creator_id in " +
            "<foreach collection='ids' item='item' open='(' separator=',' close=')'>" +
            " #{item} " +
            "</foreach>" +
            "</if>" +
            "<if test='post.location!=null'>" +
            "and location like CONCAT('%',#{post.location},'%') " +
            "</if>" +
            "<if test='post.createTime!=null'>" +
            "and create_time = #{post.createTime} " +
            "</if>" +
            "<if test='post.creatorId!=null'>" +
            "and creator_id = #{post.creatorId} " +
            "</if>" +
            "and del_flag = 0 " +
            "</where>" +
            "order by id desc" +
            "</script>")
    IPage<PostVO> listPoster(IPage<PostVO> page, @Param("post") YizouPost yizouPost,@Param("ids") List<Integer> ids);
}
