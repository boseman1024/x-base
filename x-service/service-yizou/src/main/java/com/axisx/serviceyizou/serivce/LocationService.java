package com.axisx.serviceyizou.serivce;

import com.axisx.apiyizou.dto.ListLocationDTO;
import com.axisx.apiyizou.entity.YizouLocation;

import java.util.List;

public interface LocationService {
    List<YizouLocation> getMyLocation(ListLocationDTO listLocationDTO);
}
