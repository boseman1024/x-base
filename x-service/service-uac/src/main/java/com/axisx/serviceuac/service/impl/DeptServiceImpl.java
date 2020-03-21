package com.axisx.serviceuac.service.impl;

import com.axisx.apiuac.dto.*;
import com.axisx.apiuac.entity.SysDept;
import com.axisx.apiuac.entity.SysDeptMenu;
import com.axisx.apiuac.entity.SysDeptRole;
import com.axisx.apiuac.entity.SysRoleMenu;
import com.axisx.apiuac.vo.DeptTreeVO;
import com.axisx.apiuac.vo.DeptVO;
import com.axisx.apiuac.vo.MenuVO;
import com.axisx.apiuac.vo.RoleVO;
import com.axisx.serviceuac.dao.*;
import com.axisx.serviceuac.service.DeptMenuService;
import com.axisx.serviceuac.service.DeptService;
import com.axisx.xutil.util.RedisUtil;
import com.axisx.xutil.util.TreeUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Axisx
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, SysDept> implements DeptService {

    @Autowired
    private DeptRoleMapper deptRoleMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;
    @Autowired
    private DeptMenuMapper deptMenuMapper;
    @Autowired
    private DeptMenuService deptMenuService;
    @Autowired
    private RedisUtil redisUtil;
    private SysDept sysDept;
    private BeanCopier beanCopier;

    @Override
    public DeptVO getDept(Integer id) {
        sysDept = this.getById(id);
        beanCopier = BeanCopier.create(SysDept.class,DeptVO.class,false);
        DeptVO deptVO = new DeptVO();
        beanCopier.copy(sysDept,deptVO,null);
        // 角色
        List<SysDeptRole> sysDeptRoles = deptRoleMapper.selectList(Wrappers.<SysDeptRole>lambdaQuery().eq(SysDeptRole::getDeptId,id));
        Integer[] roles = sysDeptRoles.stream().mapToInt(data->data.getRoleId()).boxed().toArray(Integer[]::new);
        deptVO.setRoles(roles);
        // 角色资源
        Set<Integer> menuSet = new HashSet<>();
        sysDeptRoles.forEach(deptRole->{
            List<Integer> menuList = roleMenuMapper.selectList(Wrappers.<SysRoleMenu>lambdaQuery().eq(SysRoleMenu::getRoleId,deptRole.getRoleId())).stream().mapToInt(data->data.getMenuId()).boxed().collect(Collectors.toList());
            menuSet.addAll(menuList);
        });
        // 自有资源
        List<Integer> ownMenuList = deptMenuMapper.selectList(Wrappers.<SysDeptMenu>lambdaQuery().eq(SysDeptMenu::getDeptId,id)).stream().mapToInt(data->data.getMenuId()).boxed().collect(Collectors.toList());
        deptVO.setMenus(ownMenuList.stream().toArray(Integer[]::new));
        menuSet.addAll(ownMenuList);
        deptVO.setAllMenus(menuSet.toArray(new Integer[menuSet.size()]));
        return deptVO;
    }

    @Override
    public IPage<DeptVO> listDept(ListDeptDTO listDeptDTO) {
        beanCopier = BeanCopier.create(ListDeptDTO.class,SysDept.class,false);
        sysDept = new SysDept();
        beanCopier.copy(listDeptDTO,sysDept,null);
        IPage<DeptVO> page = this.baseMapper.listDept(new Page<>(listDeptDTO.getPageNo(),listDeptDTO.getPageSize()),sysDept);
        return page;
    }

    @Override
    public DeptVO saveDept(SaveDeptDTO saveDeptDTO) {
        beanCopier = BeanCopier.create(SaveDeptDTO.class,SysDept.class,false);
        sysDept = new SysDept();
        beanCopier.copy(saveDeptDTO,sysDept,null);
        this.save(sysDept);
        DeptMenuDTO deptMenuDTO = new DeptMenuDTO(sysDept.getDeptId(),saveDeptDTO.getMenus());
        deptMenuService.saveDeptMenus(deptMenuDTO);
        beanCopier = BeanCopier.create(SysDept.class,DeptVO.class,false);
        DeptVO deptVO = new DeptVO();
        beanCopier.copy(sysDept,deptVO,null);
        return deptVO;
    }

    @Override
    public Boolean removeDept(Integer id) {
        deptRoleMapper.delete(Wrappers.<SysDeptRole>lambdaUpdate().eq(SysDeptRole::getDeptId,id));
        deptMenuMapper.delete(Wrappers.<SysDeptMenu>lambdaUpdate().eq(SysDeptMenu::getDeptId,id));
        return this.removeById(id);
    }

    @Override
    public DeptVO updateDept(UpdateDeptDTO updateDeptDTO) {
        beanCopier = BeanCopier.create(UpdateDeptDTO.class,SysDept.class,false);
        sysDept = new SysDept();
        beanCopier.copy(updateDeptDTO,sysDept,null);
        this.updateById(sysDept);
        DeptMenuDTO deptMenuDTO = new DeptMenuDTO(sysDept.getDeptId(),updateDeptDTO.getMenus());
        deptMenuService.saveDeptMenus(deptMenuDTO);
        beanCopier = BeanCopier.create(SysDept.class,DeptVO.class,false);
        DeptVO deptVO = new DeptVO();
        beanCopier.copy(sysDept,deptVO,null);
        return deptVO;
    }

    @Override
    public List<DeptTreeVO> getDeptTree(Integer id) {
        List<DeptTreeVO> treeList = (List<DeptTreeVO>)redisUtil.get("DeptList");
        if(treeList!=null){
            return TreeUtil.build(treeList,id);
        }
        treeList = this.list().stream().map(dept->{
            DeptTreeVO deptTreeVO = new DeptTreeVO();
            deptTreeVO.setId(dept.getDeptId());
            deptTreeVO.setLabel(dept.getName());
            deptTreeVO.setPid(dept.getPid());
            deptTreeVO.setValue(dept.getDeptId().toString());
            deptTreeVO.setType(dept.getType());
            return deptTreeVO;
        }).collect(Collectors.toList());
        redisUtil.set("DeptList",treeList);
        return TreeUtil.build(treeList,id);
    }

    @Override
    public DeptVO getDeptByUserId(Integer id) {
        return this.baseMapper.getDeptByUserId(id);
    }
}
