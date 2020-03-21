package com.axisx.serviceuac.dao;

import com.axisx.apiuac.entity.SysDict;
import com.axisx.apiuac.vo.DictVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Axisx
 */
@Mapper
public interface DictMapper extends BaseMapper<SysDict> {

    /**
     * 模糊查询字典列表(分页)
     * @param page
     * @param sysDict
     * @return
     */
    @Select("<script>" +
            "select id,code,label,value,type,description,pid,sort,create_time,update_time,del_flag " +
            "from sys_dict " +
            "<where> 1=1 " +
            "<if test='sd.label!=null'>" +
            "and label like CONCAT('%',#{sd.label},'%') " +
            "</if>" +
            "<if test='sd.type!=null'>" +
            "and type = #{sd.type} " +
            "</if>" +
            "<if test='sd.pid!=null'>" +
            "and pid = #{sd.pid} " +
            "</if>" +
            "and del_flag=0" +
            "</where>" +
            "</script>")
    IPage<DictVO> listDict(IPage<DictVO> page, @Param("sd") SysDict sysDict);

    /**
     * 查询子集
     * @param pid
     * @return
     */
    @Select("<script>" +
            "select id,code,label,value,type,description,pid,sort,create_time,update_time,del_flag " +
            "from sys_dict " +
            "<where> 1=1 " +
            "<if test='pid!=null'>" +
            "and pid = #{pid} " +
            "</if>" +
            "and del_flag=0" +
            "</where>" +
            "</script>")
    List<DictVO> getChild( @Param("pid") Integer pid);
}
