package com.axisx.serviceuac.dao;

import com.axisx.apiuac.entity.SysMenu;
import com.axisx.apiuac.vo.MenuVO;
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
public interface MenuMapper extends BaseMapper<SysMenu> {
    /**
     * 模糊查询资源列表
     * @param page
     * @param sysMenu
     * @return
     */
    @Select("<script>" +
            "select menu_id,name,permission,type,path,component,icon,sort,create_time,update_time,del_flag " +
            "from sys_menu " +
            "<where> 1=1 " +
            "<if test='sm.name!=null'>" +
            "and name like CONCAT('%',#{sm.name},'%') " +
            "</if>" +
            "<if test='sm.type!=null'>" +
            "and type = #{sm.type} " +
            "</if>" +
            "</where>" +
            "</script>")
    IPage<MenuVO> listMenu(IPage<MenuVO> page, @Param("sm") SysMenu sysMenu);

    /**
     * @param id
     * @return
     */
    @Select("select m.* " +
            "from sys_menu m,sys_role_menu rm " +
            "where m.menu_id = rm.menu_id and m.del_flag=0 and rm.role_id = #{id}")
    List<MenuVO> listMenuByRoleId(@Param("id") Integer id);
}
