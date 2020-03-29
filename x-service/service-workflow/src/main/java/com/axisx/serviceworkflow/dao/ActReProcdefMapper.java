package com.axisx.serviceworkflow.dao;

import com.axisx.apiworkflow.entity.ActReProcdef;
import com.axisx.apiworkflow.vo.ProcessVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ActReProcdefMapper extends BaseMapper<ActReProcdef> {
    /**
     * 模糊查询流程列表
     * @param page
     * @param actReProcdef
     * @return
     */
    @Select("<script>" +
            "select ID_,REV_,CATEGORY_,NAME_,KEY_,VERSION_,DEPLOYMENT_ID_,RESOURCE_NAME_,DGRM_RESOURCE_NAME_,HAS_START_FORM_KEY_,SUSPENSION_STATE_,TENANT_ID_,VERSION_TAG_,HISTORY_TTL_,STARTABLE_ " +
            "from act_re_procdef " +
            "<where> 1=1 " +
            "<if test='actReProcdef.name!=null'>" +
            "and NAME_ like CONCAT('%',#{actReProcdef.name},'%') " +
            "</if>" +
            "<if test='actReProcdef.key!=null'>" +
            "and KEY_ like CONCAT('%',#{actReProcdef.key},'%') " +
            "</if>" +
            "<if test='actReProcdef.resourceName!=null'>" +
            "and RESOURCE_NAME_ like CONCAT('%',#{actReProcdef.resourceName},'%') " +
            "</if>" +
            "<if test='actReProcdef.suspensionState!=null'>" +
            "and SUSPENSION_STATE_ = #{actReProcdef.suspensionState} " +
            "</if>" +
            "<if test='actReProcdef.startAble!=null'>" +
            "and STARTABLE_ = #{actReProcdef.startAble} " +
            "</if>" +
            "<if test='actReProcdef.category!=null'>" +
            "and CATEGORY_ = like CONCAT('%',#{actReProcdef.category},'%') " +
            "</if>" +
            "</where>" +
            "<if test='actReProcdef.group!=null'>" +
            " group by NAME_" +
            "</if>" +
            "</script>")
    IPage<ProcessVO> listProcess(IPage<ProcessVO> page, @Param("actReProcdef") ActReProcdef actReProcdef);
}
