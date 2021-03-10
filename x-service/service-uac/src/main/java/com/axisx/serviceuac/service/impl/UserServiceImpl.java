package com.axisx.serviceuac.service.impl;

import com.axisx.apiuac.dto.*;
import com.axisx.apiuac.entity.SysUser;
import com.axisx.apiuac.vo.MenuVO;
import com.axisx.apiuac.vo.RoleVO;
import com.axisx.apiuac.vo.UserVO;
import com.axisx.serviceuac.dao.UserMapper;
import com.axisx.serviceuac.service.*;
import com.axisx.xsecurity.util.SecurityUtil;
import com.axisx.xutil.util.RedisUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Axisx
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, SysUser> implements UserService {

    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private DeptService deptService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private DeptUserService deptUserService;
    @Autowired
    private RedisUtil redisUtil;

    private SysUser sysUser;
    private BeanCopier beanCopier;

    @Override
    public UserDetailDTO getCurrent() {
        if(SecurityUtil.getUsername().isEmpty()){
            return null;
        }
        return getUserDetail(SecurityUtil.getUsername());
    }

    @Override
    public UserDetailDTO getUserDetail(String username) {
        SysUser sysUser = new SysUser();
        sysUser.setUsername(username);
        sysUser = this.getOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUsername,username));
        UserDetailDTO userDetailDTO = new UserDetailDTO();
        userDetailDTO.setSysUser(sysUser);
        // 部门
        userDetailDTO.setDept(deptService.getDeptByUserId(sysUser.getUserId()));
        // 角色
        List<RoleVO> roles = roleService.listRoleByUserId(sysUser.getUserId());
        List<Integer> roleIds = roles.stream().map(RoleVO::getRoleId).collect(Collectors.toList());
        Integer[] roleIdsArr = new Integer[roleIds.size()];
        roleIds.toArray(roleIdsArr);
        userDetailDTO.setRoles(roleIdsArr);
        userDetailDTO.setRoleList(roles);
        // 资源
        Map<Integer,Boolean> temp = new HashMap<>();
        List<MenuVO> menuPermissions = new ArrayList<>();
        List<String> menuPermissionsStr = new ArrayList<>();
        roleIds.forEach(roleId->{
            List<MenuVO> menus = menuService.listMenuByRoleId(roleId);
            menus.forEach(menuVO -> {
                if(temp.get(menuVO.getMenuId())!=null){
                    return;
                }
                menuPermissions.add(menuVO);
                menuPermissionsStr.add(menuVO.getPermission());
                temp.put(menuVO.getMenuId(),true);
            });
        });
        String[] menusArr = new String[roleIds.size()];
        menuPermissionsStr.toArray(menusArr);
        userDetailDTO.setMenus(menusArr);
        userDetailDTO.setMenuList(menuPermissions);
        return userDetailDTO;
    }

    @Override
    public UserVO getUser(Integer id) {
        SysUser sysUser = this.getById(id);
        if(sysUser==null){
            return null;
        }
        return entityToVO(sysUser);
    }

    @Override
    public IPage<UserVO> listUser(ListUserDTO listUserDTO) {
        beanCopier = BeanCopier.create(ListUserDTO.class,SysUser.class,false);
        sysUser = new SysUser();
        beanCopier.copy(listUserDTO,sysUser,null);
        IPage<UserVO> page = this.baseMapper.listUser(new Page<>(listUserDTO.getPageNo(),listUserDTO.getPageSize()),sysUser,listUserDTO.getDeptId());
        return page;
    }

    @Override
    public UserVO saveUser(SaveUserDTO saveUserDTO) {
        beanCopier = BeanCopier.create(SaveUserDTO.class,SysUser.class,false);
        sysUser = new SysUser();
        beanCopier.copy(saveUserDTO,sysUser,null);
        sysUser.setPassword(new BCryptPasswordEncoder().encode(sysUser.getPassword()));
        if(checkUsername(sysUser.getUsername())){
            return null;
        }
        this.save(sysUser);
        deptUserService.saveDeptUser(new DeptUserDTO(saveUserDTO.getDeptId(),sysUser.getUserId()));
        userRoleService.saveUserRoles(new UserRoleDTO(sysUser.getUserId(),saveUserDTO.getRoles()));
        redisUtil.add("ALL_USER",sysUser.getUserId().toString());
        return entityToVO(sysUser);
    }

    @Override
    public Boolean removeUser(Integer id) {
        if(this.removeById(id)){
            redisUtil.removeMember("ALL_USER",id.toString());
            return true;
        }
        return false;
    }

    @Override
    public UserVO updateUser(UpdateUserDTO updateUserDTO) {
        beanCopier = BeanCopier.create(UpdateUserDTO.class,SysUser.class,false);
        sysUser = new SysUser();
        beanCopier.copy(updateUserDTO,sysUser,null);
        if(sysUser.getPassword()!=null){
            sysUser.setPassword(new BCryptPasswordEncoder().encode(sysUser.getPassword()));
        }
        this.updateById(sysUser);
        deptUserService.saveDeptUser(new DeptUserDTO(updateUserDTO.getDeptId(),sysUser.getUserId()));
        userRoleService.saveUserRoles(new UserRoleDTO(sysUser.getUserId(),updateUserDTO.getRoles()));
        return entityToVO(sysUser);
    }

    @Override
    public Boolean checkUsername(String username) {
        Boolean result = redisUtil.hmGet("UsernameStore",username)!=null;
        if(!result){
            result = this.getOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUsername, username)) != null;
            if(result){
                redisUtil.hmSet("UsernameStore",username,username);
            }
        }
        return result;
    }

    public UserVO entityToVO(SysUser sysUser){
        beanCopier = BeanCopier.create(SysUser.class,UserVO.class,false);
        UserVO userVO = new UserVO();
        beanCopier.copy(sysUser,userVO,null);
        return userVO;
    }
}
