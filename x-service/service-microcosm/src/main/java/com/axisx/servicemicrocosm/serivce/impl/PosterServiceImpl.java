package com.axisx.servicemicrocosm.serivce.impl;

import com.axisx.apiyizou.dto.ListPosterDTO;
import com.axisx.apiyizou.dto.SavePosterDTO;
import com.axisx.apiyizou.dto.UpdatePosterDTO;
import com.axisx.apiyizou.entity.MicrocosmPoster;
import com.axisx.apiyizou.vo.PosterVO;
import com.axisx.servicemicrocosm.dao.PosterMapper;
import com.axisx.servicemicrocosm.serivce.PosterMediaService;
import com.axisx.servicemicrocosm.serivce.PosterService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

@Service
public class PosterServiceImpl extends ServiceImpl<PosterMapper, MicrocosmPoster> implements PosterService {
    @Autowired
    private PosterMediaService posterMediaService;
    private BeanCopier beanCopier;
    private MicrocosmPoster microcosmPoster;

    @Override
    public IPage<PosterVO> listPoster(ListPosterDTO listPosterDTO) {
        beanCopier = BeanCopier.create(ListPosterDTO.class,MicrocosmPoster.class,false);
        microcosmPoster = new MicrocosmPoster();
        beanCopier.copy(listPosterDTO,microcosmPoster,null);
        IPage<PosterVO> page = this.baseMapper.listPoster(new Page<>(listPosterDTO.getPageNo(),listPosterDTO.getPageSize()),microcosmPoster);
        page.getRecords().stream().forEach(data->{
            data.setMedias(posterMediaService.listByPosterId(data.getId()));
        });
        return page;
    }

    @Override
    public Boolean savePoster(SavePosterDTO savePosterDTO) {
        beanCopier = BeanCopier.create(SavePosterDTO.class,MicrocosmPoster.class,false);
        microcosmPoster = new MicrocosmPoster();
        beanCopier.copy(savePosterDTO,microcosmPoster,null);
        Boolean result = this.save(microcosmPoster);
        if(result&&savePosterDTO.getMedias()!=null){
            savePosterDTO.getMedias().stream().forEach(media->{
                media.setPosterId(microcosmPoster.getId());
                posterMediaService.save(media);
            });
        }
        return result;
    }

    @Override
    public Boolean removePoster(Integer id) {
        posterMediaService.removerByPosterId(id);
        return this.removeById(id);
    }

    @Override
    public Boolean updatePoster(UpdatePosterDTO updatePosterDTO) {
        beanCopier = BeanCopier.create(UpdatePosterDTO.class,MicrocosmPoster.class,false);
        microcosmPoster = new MicrocosmPoster();
        beanCopier.copy(updatePosterDTO,microcosmPoster,null);
        posterMediaService.removerByPosterId(updatePosterDTO.getId());
        if(updatePosterDTO.getMedias()!=null){
            updatePosterDTO.getMedias().stream().forEach(media->{
                media.setPosterId(microcosmPoster.getId());
                posterMediaService.save(media);
            });
        }
        return this.updateById(microcosmPoster);
    }
}
