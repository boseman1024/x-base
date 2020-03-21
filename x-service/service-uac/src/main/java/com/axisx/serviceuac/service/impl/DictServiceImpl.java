package com.axisx.serviceuac.service.impl;

import com.axisx.apiuac.dto.*;
import com.axisx.apiuac.entity.SysDict;
import com.axisx.apiuac.vo.DictTreeVO;
import com.axisx.apiuac.vo.DictVO;
import com.axisx.serviceuac.dao.DictMapper;
import com.axisx.serviceuac.service.DictService;
import com.axisx.xutil.util.RedisUtil;
import com.axisx.xutil.util.TreeUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.bouncycastle.jcajce.provider.symmetric.AES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Axisx
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, SysDict> implements DictService {

    private SysDict sysDict;
    private BeanCopier beanCopier;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public DictVO getDict(Integer id) {
        sysDict = this.getById(id);
        beanCopier = BeanCopier.create(SysDict.class,DictVO.class,false);
        DictVO dictVO = new DictVO();
        beanCopier.copy(sysDict,dictVO,null);
        return dictVO;
    }

    @Override
    public IPage<DictVO> listDict(ListDictDTO listDictDTO) {
        beanCopier = BeanCopier.create(ListDictDTO.class,SysDict.class,false);
        sysDict = new SysDict();
        beanCopier.copy(listDictDTO,sysDict,null);
        IPage<DictVO> page = this.baseMapper.listDict(new Page<>(listDictDTO.getPageNo(),listDictDTO.getPageSize()),sysDict);
        return page;
    }

    @Override
    public DictVO saveDict(SaveDictDTO saveDictDTO) {
        beanCopier = BeanCopier.create(SaveDictDTO.class,SysDict.class,false);
        sysDict = new SysDict();
        beanCopier.copy(saveDictDTO,sysDict,null);
        if(checkCode(sysDict.getCode())){
            return null;
        }
        this.save(sysDict);
        beanCopier = BeanCopier.create(SysDict.class,DictVO.class,false);
        DictVO dictVO = new DictVO();
        beanCopier.copy(sysDict,dictVO,null);
        return dictVO;
    }

    @Override
    public Boolean removeDict(Integer id) {
        return this.removeById(id);
    }

    @Override
    public DictVO updateDict(UpdateDictDTO updateDictDTO) {
        beanCopier = BeanCopier.create(UpdateDictDTO.class,SysDict.class,false);
        sysDict = new SysDict();
        beanCopier.copy(updateDictDTO,sysDict,null);
        this.updateById(sysDict);
        beanCopier = BeanCopier.create(SysDict.class,DictVO.class,false);
        DictVO dictVO = new DictVO();
        beanCopier.copy(sysDict,dictVO,null);
        return dictVO;
    }

    @Override
    public List<DictTreeVO> getDictTree(Integer id) {
        List<DictTreeVO> treeList = (List<DictTreeVO>)redisUtil.get("DictList");
        if(treeList!=null){
            return TreeUtil.build(treeList,id);
        }
        treeList = this.list().stream().map(dept->{
            DictTreeVO dictTreeVO = new DictTreeVO();
            dictTreeVO.setId(dept.getId());
            dictTreeVO.setLabel(dept.getLabel());
            dictTreeVO.setPid(dept.getPid());
            dictTreeVO.setValue(dept.getValue());
            dictTreeVO.setType(dept.getType());
            return dictTreeVO;
        }).collect(Collectors.toList());
        redisUtil.set("DictList",treeList);
        return TreeUtil.build(treeList,id);
    }

    @Override
    public List<DictVO> getChild(String code) {
        List<DictVO> list = (List<DictVO>)redisUtil.hmGet("DictMap",code);
        if(list!=null){
            return list;
        }
        sysDict = this.getOne(Wrappers.<SysDict>lambdaQuery().eq(SysDict::getCode,code));
        if(sysDict!=null){
            list = this.baseMapper.getChild(sysDict.getId());
            return list;
        }
        return new ArrayList<>();
    }

    @Override
    public Boolean checkCode(String code) {
        Boolean result = redisUtil.hmGet("DictCodeStore",code)!=null;
        if(!result){
            result = this.getOne(Wrappers.<SysDict>lambdaQuery().eq(SysDict::getCode,code))!=null;
            if(result){
                redisUtil.hmSet("DictCodeStore",code,code);
            }
        }
        return result;
    }
}
