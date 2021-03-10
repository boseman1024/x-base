package com.axisx.servicemicrocosm.serivce.impl;

import com.axisx.apiyizou.dto.MediaDTO;

import com.axisx.apiyizou.entity.MicrocosmPosterMedia;
import com.axisx.servicemicrocosm.dao.PosterMediaMapper;
import com.axisx.servicemicrocosm.serivce.PosterMediaService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosterMediaServiceImpl extends ServiceImpl<PosterMediaMapper, MicrocosmPosterMedia> implements PosterMediaService {

    private BeanCopier beanCopier;
    private MicrocosmPosterMedia microcosmPosterMedia;

    @Override
    public List<MicrocosmPosterMedia> listByPosterId(Integer posterId) {
        return this.list(Wrappers.<MicrocosmPosterMedia>lambdaQuery().eq(MicrocosmPosterMedia::getPosterId,posterId));
    }

    @Override
    public Boolean removerByPosterId(Integer posterId) {
        return this.remove(Wrappers.<MicrocosmPosterMedia>lambdaUpdate().eq(MicrocosmPosterMedia::getPosterId,posterId));
    }

    @Override
    public Boolean save(MediaDTO mediaDTO) {
        beanCopier = BeanCopier.create(MediaDTO.class, MicrocosmPosterMedia.class,false);
        microcosmPosterMedia = new MicrocosmPosterMedia();
        beanCopier.copy(mediaDTO,microcosmPosterMedia,null);
        return this.save(microcosmPosterMedia);
    }
}
