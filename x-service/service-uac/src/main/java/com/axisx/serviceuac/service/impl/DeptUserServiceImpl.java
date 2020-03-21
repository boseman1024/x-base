package com.axisx.serviceuac.service.impl;

import com.axisx.apiuac.dto.DeptUserDTO;
import com.axisx.apiuac.entity.SysDeptUser;
import com.axisx.serviceuac.dao.DeptUserMapper;
import com.axisx.serviceuac.service.DeptUserService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class DeptUserServiceImpl extends ServiceImpl<DeptUserMapper, SysDeptUser>  implements DeptUserService {
    @Override
    public Boolean saveDeptUser(DeptUserDTO deptUserDTO) {
        Integer deptId = deptUserDTO.getDeptId();
        Integer userId = deptUserDTO.getUserId();
        this.remove(Wrappers.<SysDeptUser>lambdaUpdate().eq(SysDeptUser::getUserId,userId));
        return this.save(new SysDeptUser(deptId,userId));
    }
}
