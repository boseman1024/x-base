package com.axisx.apiyizou.api;

import com.axisx.apicommon.dto.ResponseDTO;
import com.axisx.apiyizou.dto.ListLocationDTO;
import com.axisx.apiyizou.entity.YizouLocation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/location")
public interface LocationApi {

    @PostMapping("/my")
    ResponseDTO<List<YizouLocation>> getMyLocation(@RequestBody ListLocationDTO listLocationDTO);
}
