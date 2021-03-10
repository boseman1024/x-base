package com.axisx.servicemicrocosm.dao;

import com.axisx.apiyizou.entity.MicrocosmPoster;
import com.axisx.apiyizou.vo.PosterVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PosterMapper extends BaseMapper<MicrocosmPoster> {
    /**
     * 模糊查询列表(分页)
     * @param page
     * @param microcosmPoster
     * @return
     */
    @Select("<script>" +
            "select id,title,author,date,description,sort,type,creator_id,create_time,update_time,del_flag " +
            "from microcosm_poster " +
            "<where> 1=1 " +
            "<if test='poster.title!=null'>" +
            "and title like CONCAT('%',#{poster.title},'%') " +
            "</if>" +
            "<if test='poster.author!=null'>" +
            "and author like CONCAT('%',#{poster.author},'%') " +
            "</if>" +
            "<if test='poster.type!=null'>" +
            "and type = #{poster.type} " +
            "</if>" +
            "<if test='poster.creatorId!=null'>" +
            "and creator_id = #{poster.creatorId} " +
            "</if>" +
            "and del_flag=0" +
            "</where>" +
            "</script>")
    IPage<PosterVO> listPoster(IPage<PosterVO> page, @Param("poster") MicrocosmPoster microcosmPoster);
}
