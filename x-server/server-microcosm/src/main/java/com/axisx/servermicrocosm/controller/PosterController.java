package com.axisx.servermicrocosm.controller;

import com.axisx.apicommon.dto.ResponseDTO;
import com.axisx.apiyizou.api.PosterApi;
import com.axisx.apiyizou.dto.ListPosterDTO;
import com.axisx.apiyizou.dto.SavePosterDTO;
import com.axisx.apiyizou.dto.UpdatePosterDTO;
import com.axisx.servicemicrocosm.serivce.PosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PosterController implements PosterApi {
    @Autowired
    private PosterService posterService;

    @Override
    public ResponseDTO listPosters(ListPosterDTO request) {
        return ResponseDTO.success(posterService.listPoster(request));
    }

    @Override
    public ResponseDTO savePoster(SavePosterDTO request) {
        return ResponseDTO.success(posterService.savePoster(request));
    }

    @Override
    public ResponseDTO removePoster(Integer id) {
        return ResponseDTO.success(posterService.removePoster(id));
    }

    @Override
    public ResponseDTO updatePoster(UpdatePosterDTO request) {
        return ResponseDTO.success(posterService.updatePoster(request));
    }
}
