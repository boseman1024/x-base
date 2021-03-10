package com.axisx.servicemicrocosm.serivce;

import com.axisx.apiyizou.dto.ListPosterDTO;
import com.axisx.apiyizou.dto.SavePosterDTO;
import com.axisx.apiyizou.dto.UpdatePosterDTO;
import com.axisx.apiyizou.vo.PosterVO;
import com.baomidou.mybatisplus.core.metadata.IPage;

public interface PosterService {
    IPage<PosterVO> listPoster(ListPosterDTO listPosterDTO);

    Boolean savePoster(SavePosterDTO savePosterDTO);

    Boolean removePoster(Integer id);

    Boolean updatePoster(UpdatePosterDTO updatePosterDTO);
}
