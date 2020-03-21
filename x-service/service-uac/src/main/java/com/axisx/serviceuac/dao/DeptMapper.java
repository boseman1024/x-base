package com.axisx.serviceuac.dao;

import com.axisx.apiuac.entity.SysDept;
import com.axisx.apiuac.vo.DeptVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

/**
 * @author Axisx
 */
@Mapper
public interface DeptMapper extends BaseMapper<SysDept> {
    /**
     * 模糊查询部门列表
     * @param page
     * @param sysDept
     * @return
     */
    @Select("<script>" +
            "select dept_id,name,type,pid,sort,create_time,update_time,del_flag " +
            "from sys_dept " +
            "<where> 1=1 " +
            "<if test='sd.name!=null'>" +
            "and name like CONCAT('%',#{sd.name},'%') " +
            "</if>" +
            "<if test='sd.type!=null'>" +
            "and type = #{sd.type} " +
            "</if>" +
            "<if test='sd.pid!=null'>" +
            "and pid = #{sd.pid} " +
            "</if>" +
            "and del_flag=0 " +
            "</where>" +
            "</script>")
    IPage<DeptVO> listDept(IPage<DeptVO> page, @Param("sd") SysDept sysDept);

    /**
     * 查询用户所在部门
     * @param userId
     * @return
     */
    @Select("<script>" +
            "select sd.dept_id,name,type,pid,sort,create_time,update_time,del_flag " +
            "from sys_dept sd left join sys_dept_user sdu on sd.dept_id = sdu.dept_id " +
            "where sdu.user_id = #{userId} and del_flag=0 " +
            "limit 1 " +
            "</script>")
    DeptVO getDeptByUserId(@Param("userId") Integer userId);
}
