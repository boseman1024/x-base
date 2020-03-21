package com.axisx.servicemessage.dao;

import com.axisx.apimessage.entity.MsgStore;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MsgMapper extends BaseMapper<MsgStore> {
}
