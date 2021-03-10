package com.axisx.servicemicrocosm.serivce;

import com.axisx.apiyizou.dto.MediaDTO;
import com.axisx.apiyizou.entity.MicrocosmPosterMedia;

import java.util.List;

public interface PosterMediaService {
    List<MicrocosmPosterMedia> listByPosterId(Integer posterId);
    Boolean removerByPosterId(Integer posterId);
    Boolean save(MediaDTO mediaDTO);
}
