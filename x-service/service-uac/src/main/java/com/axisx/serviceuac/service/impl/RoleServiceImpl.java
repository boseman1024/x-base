package com.axisx.serviceuac.service.impl;

import com.axisx.apiuac.dto.*;
import com.axisx.apiuac.entity.SysDeptMenu;
import com.axisx.apiuac.entity.SysDeptRole;
import com.axisx.apiuac.entity.SysRole;
import com.axisx.apiuac.entity.SysRoleMenu;
import com.axisx.apiuac.vo.RoleVO;
import com.axisx.serviceuac.dao.DeptMenuMapper;
import com.axisx.serviceuac.dao.DeptRoleMapper;
import com.axisx.serviceuac.dao.RoleMapper;
import com.axisx.serviceuac.dao.RoleMenuMapper;
import com.axisx.serviceuac.service.RoleMenuService;
import com.axisx.serviceuac.service.RoleService;
import com.axisx.xutil.util.RedisUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Axisx
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, SysRole> implements RoleService {
    @Autowired
    private DeptRoleMapper deptRoleMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;
    @Autowired
    private RoleMenuService roleMenuService;
    private SysRole sysRole;
    private BeanCopier beanCopier;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<RoleVO> listRoleByUserId(Integer id) {
        return this.baseMapper.listRoleByUserId(id);
    }

    @Override
    public RoleVO getRole(Integer id) {
        sysRole = this.getById(id);
        beanCopier = BeanCopier.create(SysRole.class,RoleVO.class,false);
        RoleVO roleVO = new RoleVO();
        beanCopier.copy(sysRole,roleVO,null);
        // 角色资源
        List<Integer> menuList = roleMenuMapper.selectList(Wrappers.<SysRoleMenu>lambdaQuery().eq(SysRoleMenu::getRoleId,id)).stream().mapToInt(data->data.getMenuId()).boxed().collect(Collectors.toList());
        roleVO.setMenus(menuList.stream().toArray(Integer[]::new));
        return roleVO;
    }

    @Override
    public IPage<RoleVO> listRolePage(ListRoleDTO listRoleDTO) {
        beanCopier = BeanCopier.create(ListRoleDTO.class,SysRole.class,false);
        sysRole = new SysRole();
        beanCopier.copy(listRoleDTO,sysRole,null);
        IPage<RoleVO> page = this.baseMapper.listRolePage(new Page<>(listRoleDTO.getPageNo(),listRoleDTO.getPageSize()),sysRole);
        return page;
    }

    @Override
    public List<RoleVO> listRole(ListRoleDTO listRoleDTO) {
        beanCopier = BeanCopier.create(ListRoleDTO.class,SysRole.class,false);
        sysRole = new SysRole();
        beanCopier.copy(listRoleDTO,sysRole,null);
        return this.baseMapper.listRole(sysRole,listRoleDTO.getDeptId());
    }

    @Override
    public RoleVO saveRole(SaveRoleDTO saveRoleDTO) {
        beanCopier = BeanCopier.create(SaveRoleDTO.class,SysRole.class,false);
        sysRole = new SysRole();
        beanCopier.copy(saveRoleDTO,sysRole,null);
        if(checkCode(sysRole.getCode())){
            return null;
        }
        this.save(sysRole);
        deptRoleMapper.insert(new SysDeptRole(saveRoleDTO.getDeptId(),sysRole.getRoleId()));
        RoleMenuDTO roleMenuDTO = new RoleMenuDTO(sysRole.getRoleId(),saveRoleDTO.getMenus());
        roleMenuService.saveRoleMenus(roleMenuDTO);
        beanCopier = BeanCopier.create(SysRole.class,RoleVO.class,false);
        RoleVO roleVO = new RoleVO();
        beanCopier.copy(sysRole,roleVO,null);
        return roleVO;
    }

    @Override
    public Boolean removeRole(Integer id) {
        roleMenuMapper.delete(Wrappers.<SysRoleMenu>lambdaUpdate().eq(SysRoleMenu::getRoleId,id));
        deptRoleMapper.delete(Wrappers.<SysDeptRole>lambdaUpdate().eq(SysDeptRole::getRoleId,id));
        return this.removeById(id);
    }

    @Override
    public RoleVO updateRole(UpdateRoleDTO updateRoleDTO) {
        beanCopier = BeanCopier.create(UpdateRoleDTO.class,SysRole.class,false);
        sysRole = new SysRole();
        beanCopier.copy(updateRoleDTO,sysRole,null);
        // TODO CODE字段检查
        this.updateById(sysRole);
        RoleMenuDTO roleMenuDTO = new RoleMenuDTO(sysRole.getRoleId(),updateRoleDTO.getMenus());
        roleMenuService.saveRoleMenus(roleMenuDTO);
        beanCopier = BeanCopier.create(SysRole.class,RoleVO.class,false);
        RoleVO roleVO = new RoleVO();
        beanCopier.copy(sysRole,roleVO,null);
        return roleVO;
    }

    @Override
    public Boolean checkCode(String code) {
        Boolean result = redisUtil.hmGet("RoleCodeStore",code)!=null;
        if(!result){
            result = this.getOne(Wrappers.<SysRole>lambdaQuery().eq(SysRole::getCode,code))!=null;
            if(result){
                redisUtil.hmSet("RoleCodeStore",code,code);
            }
        }
        return result;
    }
}
