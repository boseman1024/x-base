package com.axisx.serviceuac.service;

import com.axisx.apiuac.dto.*;
import com.axisx.apiuac.vo.DeptTreeVO;
import com.axisx.apiuac.vo.DeptVO;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * @author Axisx
 */
public interface DeptService {

    DeptVO getDept(Integer id);

    IPage<DeptVO> listDept(ListDeptDTO listDeptDTO);

    DeptVO saveDept(SaveDeptDTO saveDeptDTO);

    Boolean removeDept(Integer id);

    DeptVO updateDept(UpdateDeptDTO updateDeptDTO);

    List<DeptTreeVO> getDeptTree(Integer id);

    DeptVO getDeptByUserId(Integer id);

}
