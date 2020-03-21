package com.axisx.serviceuac.service;

import com.axisx.apiuac.dto.*;
import com.axisx.apiuac.vo.DictTreeVO;
import com.axisx.apiuac.vo.DictVO;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * @author Axisx
 */
public interface DictService {

    DictVO getDict(Integer id);

    IPage<DictVO> listDict(ListDictDTO listDictDTO);

    DictVO saveDict(SaveDictDTO saveDictDTO);

    Boolean removeDict(Integer id);

    DictVO updateDict(UpdateDictDTO updateDictDTO);

    List<DictTreeVO> getDictTree(Integer id);

    List<DictVO> getChild(String code);

    Boolean checkCode(String code);
}
