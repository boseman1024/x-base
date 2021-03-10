package com.axisx.serviceyizou.dao;

import com.axisx.apiyizou.entity.YizouLocation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LocationMapper extends BaseMapper<YizouLocation> {
}
