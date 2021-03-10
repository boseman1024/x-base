package com.axisx.serviceyizou.serivce.impl;

import com.axisx.apiyizou.dto.ListFollowDTO;
import com.axisx.apiyizou.entity.YizouFollow;
import com.axisx.apiyizou.vo.FollowVO;
import com.axisx.serviceyizou.dao.FollowMapper;
import com.axisx.serviceyizou.feign.UserRemoteService;
import com.axisx.serviceyizou.serivce.FollowService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

@Service
public class FollowServiceImpl extends ServiceImpl<FollowMapper, YizouFollow> implements FollowService {
    private BeanCopier beanCopier;
    private YizouFollow yizouFollow;
    @Autowired
    private UserRemoteService userRemoteService;
    @Override
    public IPage<FollowVO> listFollow(ListFollowDTO listFollowDTO) {
        beanCopier = BeanCopier.create(ListFollowDTO.class,YizouFollow.class,false);
        yizouFollow = new YizouFollow();
        beanCopier.copy(listFollowDTO,yizouFollow,null);
        IPage<FollowVO> page = this.baseMapper.listFollow(new Page<>(listFollowDTO.getPageNo(),listFollowDTO.getPageSize()),yizouFollow);
        page.getRecords().stream().forEach(data->{
            //关联账号
            if(data.getFromUserId()!=null){
                data.setUser(userRemoteService.getUser(data.getFromUserId()).getData());
            }
            if(data.getToUserId()!=null){
                data.setUser(userRemoteService.getUser(data.getToUserId()).getData());
            }
        });
        return page;
    }

    @Override
    public Boolean saveOrRemoveFollow(Integer fromUserId,Integer toUserId) {
        YizouFollow yizouFollow = this.getOne(Wrappers.<YizouFollow>lambdaQuery().eq(YizouFollow::getFromUserId,fromUserId).eq(YizouFollow::getToUserId,toUserId));
        if(yizouFollow==null){
            yizouFollow = new YizouFollow();
            yizouFollow.setFromUserId(fromUserId);
            yizouFollow.setToUserId(toUserId);
            return this.save(yizouFollow);
        }
        return this.removeById(yizouFollow.getId());
    }
}
