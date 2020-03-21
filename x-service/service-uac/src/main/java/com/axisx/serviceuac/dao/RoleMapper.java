package com.axisx.serviceuac.dao;

import com.axisx.apiuac.entity.SysRole;
import com.axisx.apiuac.vo.RoleVO;
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
public interface RoleMapper extends BaseMapper<SysRole> {
    /**
     * 模糊查询角色列表(分页)
     * @param page
     * @param sysRole
     * @return
     */
    @Select("<script>" +
            "select role_id,name,code,description,create_time,update_time,del_flag " +
            "from sys_role " +
            "<where> 1=1 " +
            "<if test='sr.name!=null'>" +
            "and name like CONCAT('%',#{sr.name},'%') " +
            "</if>" +
            "</where>" +
            "</script>")
    IPage<RoleVO> listRolePage(IPage<RoleVO> page, @Param("sr") SysRole sysRole);

    /**
     * 模糊查询角色列表
     * @param sysRole
     * @param deptId
     * @return
     */
    @Select("<script>" +
            "select sr.role_id,name,code,description,create_time,update_time,del_flag " +
            "from sys_role sr " +
            "<if test='deptId!=null'>" +
            "left join sys_dept_role sdr on sr.role_id = sdr.role_id " +
            "</if>" +
            "<where> 1=1 " +
            "<if test='sr.name!=null'>" +
            "and name like CONCAT('%',#{sr.name},'%') " +
            "</if>" +
            "<if test='deptId!=null'>" +
            "and sdr.dept_id = #{deptId} " +
            "</if>" +
            "and del_flag=0 " +
            "</where>" +
            "</script>")
    List<RoleVO> listRole(@Param("sr") SysRole sysRole,@Param("deptId") Integer deptId);

    /**
     * 查询用户角色
     * @param id
     * @return
     */
    @Select("select r.* " +
            "from sys_role r,sys_user_role ur " +
            "where r.role_id = ur.role_id and r.del_flag = 0 and ur.user_id = #{id}")
    List<RoleVO> listRoleByUserId(@Param("id") Integer id);

}
