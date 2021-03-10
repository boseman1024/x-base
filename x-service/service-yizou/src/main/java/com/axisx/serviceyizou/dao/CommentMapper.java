package com.axisx.serviceyizou.dao;

import com.axisx.apiyizou.entity.YizouComment;
import com.axisx.apiyizou.vo.CommentVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CommentMapper extends BaseMapper<YizouComment> {
    /**
     * 模糊查询列表(分页)
     * @param page
     * @param yizouComment
     * @return
     */
    @Select("<script>" +
            "select id,pid,post_id,content,create_time,from_user_id,to_user_id,del_flag " +
            "from yizou_comment " +
            "<where> 1=1 " +
            "<if test='comment.id!=null'>" +
            "and id = #{comment.id} " +
            "</if>" +
            "<if test='comment.pid!=null'>" +
            "and pid = #{comment.pid} " +
            "</if>" +
            "<if test='comment.postId!=null'>" +
            "and post_id = #{comment.postId} " +
            "</if>" +
            "<if test='comment.fromUserId!=null'>" +
            "and from_user_id = #{comment.fromUserId} " +
            "</if>" +
            "<if test='comment.toUserId!=null'>" +
            "and to_user_id = #{comment.toUserId} " +
            "</if>" +
            "and del_flag=0 " +
            "</where>" +
            "order by id desc" +
            "</script>")
    IPage<CommentVO> listComment(IPage<CommentVO> page, @Param("comment") YizouComment yizouComment);
}
