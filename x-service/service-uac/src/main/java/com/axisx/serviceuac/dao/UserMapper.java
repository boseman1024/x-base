package com.axisx.serviceuac.dao;

import com.axisx.apiuac.entity.SysUser;
import com.axisx.apiuac.vo.UserVO;
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
public interface UserMapper extends BaseMapper<SysUser> {

    /**
     * 模糊查询用户列表
     * @param page
     * @param sysUser
     * @return
     */
    @Select("<script>" +
            "select su.user_id,username,password,salt,nickname,phone,avatar,create_time,update_time,state,del_flag " +
            "from sys_user su" +
            "<if test='deptId!=null'>" +
            "left join sys_dept_user sdu on su.user_id = sdu.user_id " +
            "</if>" +
            "<where> 1=1 " +
            "<if test='su.username!=null'>" +
            "and username like CONCAT('%',#{su.username},'%') " +
            "</if>" +
            "<if test='su.nickname!=null'>" +
            "and nickname like CONCAT('%',#{su.nickname},'%') " +
            "</if>" +
            "<if test='su.state!=null'>" +
            "and state = #{su.state} " +
            "</if>" +
            "<if test='deptId!=null'>" +
            "and sdu.dept_id = #{deptId} " +
            "</if>" +
            "and del_flag=0 " +
            "</where>" +
            "</script>")
    IPage<UserVO> listUser(IPage<UserVO> page, @Param("su")SysUser sysUser, @Param("deptId") Integer deptId);
}
