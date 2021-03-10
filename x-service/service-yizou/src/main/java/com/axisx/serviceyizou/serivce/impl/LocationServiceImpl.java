package com.axisx.serviceyizou.serivce.impl;

import com.axisx.apiuac.dto.ListUserDTO;
import com.axisx.apiyizou.dto.ListLocationDTO;
import com.axisx.apiyizou.entity.YizouLocation;
import com.axisx.apiyizou.entity.YizouPost;
import com.axisx.serviceyizou.dao.LocationMapper;
import com.axisx.serviceyizou.dao.PostMapper;
import com.axisx.serviceyizou.serivce.LocationService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl extends ServiceImpl<LocationMapper,YizouLocation> implements LocationService {

    @Autowired
    private PostMapper postMapper;


    @Override
    public List<YizouLocation> getMyLocation(ListLocationDTO listLocationDTO) {
        List<Integer> postIds = postMapper.selectList(
                Wrappers.<YizouPost>lambdaQuery()
                        .eq(YizouPost::getCreatorId,listLocationDTO.getUserId())
                )
                .stream()
                .map(YizouPost::getId)
                .collect(Collectors.toList());
        List<YizouLocation> list = this.list(
                Wrappers.<YizouLocation>lambdaQuery()
                        .in(YizouLocation::getPostId,postIds)
                        .eq(listLocationDTO.getAdcode()!=null,YizouLocation::getAdcode,listLocationDTO.getAdcode())
                        .eq(listLocationDTO.getCitycode()!=null,YizouLocation::getCitycode,listLocationDTO.getCitycode())
                        .eq(listLocationDTO.getPcode()!=null,YizouLocation::getPcode,listLocationDTO.getPcode())
                        .like(listLocationDTO.getName()!=null,YizouLocation::getName,listLocationDTO.getName())
                        .like(listLocationDTO.getAddress()!=null,YizouLocation::getAddress,listLocationDTO.getAddress())
                        .between(listLocationDTO.getStm()!=null&&listLocationDTO.getEtm()!=null,YizouLocation::getCreateTime,listLocationDTO.getStm(),listLocationDTO.getEtm())
                );
        return list;
    }
}
