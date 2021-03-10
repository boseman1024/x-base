package com.axisx.serveryizou.controller;

import com.axisx.apicommon.dto.ResponseDTO;
import com.axisx.apiyizou.api.LocationApi;
import com.axisx.apiyizou.dto.ListLocationDTO;
import com.axisx.apiyizou.entity.YizouLocation;
import com.axisx.serviceyizou.serivce.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationController implements LocationApi {

    @Autowired
    private LocationService locationService;

    @Override
    public ResponseDTO<List<YizouLocation>> getMyLocation(ListLocationDTO listLocationDTO) {
        return ResponseDTO.success(locationService.getMyLocation(listLocationDTO));
    }
}
