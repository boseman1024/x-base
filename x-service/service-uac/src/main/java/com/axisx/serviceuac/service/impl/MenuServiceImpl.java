package com.axisx.serviceuac.service.impl;

import com.axisx.apiuac.dto.*;
import com.axisx.apiuac.entity.SysMenu;
import com.axisx.apiuac.entity.SysRoleMenu;
import com.axisx.apiuac.enums.MenuTypeEnum;
import com.axisx.apiuac.vo.MenuCheckItemVO;
import com.axisx.apiuac.vo.MenuTreeVO;
import com.axisx.apiuac.vo.MenuVO;
import com.axisx.serviceuac.dao.MenuMapper;
import com.axisx.serviceuac.dao.RoleMenuMapper;
import com.axisx.serviceuac.service.MenuService;
import com.axisx.xutil.util.RedisUtil;
import com.axisx.xutil.util.TreeUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Axisx
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, SysMenu> implements MenuService {
    @Autowired
    private RoleMenuMapper roleMenuMapper;
    private SysMenu sysMenu;
    private BeanCopier beanCopier;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<MenuVO> listMenuByRoleId(Integer id) {
        return this.baseMapper.listMenuByRoleId(id);
    }

    @Override
    public MenuVO getMenu(Integer id) {
        sysMenu = this.getById(id);
        beanCopier = BeanCopier.create(SysMenu.class,MenuVO.class,false);
        MenuVO menuVO = new MenuVO();
        beanCopier.copy(sysMenu,menuVO,null);
        return menuVO;
    }

    @Override
    public IPage<MenuVO> listMenu(ListMenuDTO listMenuDTO) {
        beanCopier = BeanCopier.create(ListMenuDTO.class,SysMenu.class,false);
        sysMenu = new SysMenu();
        beanCopier.copy(listMenuDTO,sysMenu,null);
        IPage<MenuVO> page = this.baseMapper.listMenu(new Page<>(listMenuDTO.getPageNo(),listMenuDTO.getPageSize()),sysMenu);
        return page;
    }

    @Override
    public MenuVO saveMenu(SaveMenuDTO saveMenuDTO) {
        beanCopier = BeanCopier.create(SaveMenuDTO.class,SysMenu.class,false);
        sysMenu = new SysMenu();
        beanCopier.copy(saveMenuDTO,sysMenu,null);
        if(checkCode(sysMenu.getPermission())){
            return null;
        }
        this.save(sysMenu);
        beanCopier = BeanCopier.create(SysMenu.class,MenuVO.class,false);
        MenuVO menuVO = new MenuVO();
        beanCopier.copy(sysMenu,menuVO,null);
        return menuVO;
    }

    @Override
    public Boolean removeMenu(Integer id) {
        roleMenuMapper.delete(Wrappers.<SysRoleMenu>lambdaUpdate().eq(SysRoleMenu::getMenuId,id));
        return this.removeById(id);
    }

    @Override
    public MenuVO updateMenu(UpdateMenuDTO updateMenuDTO) {
        beanCopier = BeanCopier.create(UpdateMenuDTO.class,SysMenu.class,false);
        sysMenu = new SysMenu();
        beanCopier.copy(updateMenuDTO,sysMenu,null);
        // TODO CODE字段检查
        this.updateById(sysMenu);
        beanCopier = BeanCopier.create(SysMenu.class,MenuVO.class,false);
        MenuVO menuVO = new MenuVO();
        beanCopier.copy(sysMenu,menuVO,null);
        return menuVO;
    }

    @Override
    public List<MenuTreeVO> getMenuTree(Integer id) {
        List<MenuTreeVO> treeList = (List<MenuTreeVO>)redisUtil.get("MenuList");
        if(treeList!=null){
            return TreeUtil.build(treeList,id);
        }
        treeList = this.list().stream().map(menu->{
            MenuTreeVO menuTreeVO = new MenuTreeVO();
            menuTreeVO.setId(menu.getMenuId());
            menuTreeVO.setLabel(menu.getName());
            menuTreeVO.setPid(menu.getPid());
            menuTreeVO.setValue(menu.getMenuId().toString());
            menuTreeVO.setType(menu.getType());
            return menuTreeVO;
        }).collect(Collectors.toList());
        redisUtil.set("MenuList",treeList);
        return TreeUtil.build(treeList,id);
    }

    @Override
    public List<MenuCheckItemVO> getMenuCheckItem() {
        Map<Integer,List<MenuCheckItemVO>> menuMap = new HashMap<>();
        List<MenuCheckItemVO> checkItems = new ArrayList<>();
        this.list().stream().forEach(menu->{
            MenuCheckItemVO item = new MenuCheckItemVO();
            item.setMenuId(menu.getMenuId());
            item.setName(menu.getName());
            item.setPermission(menu.getPermission());
            item.setPid(menu.getPid());
            item.setType(menu.getType());
            if(menuMap.get(menu.getPid())==null&&menu.getType().equals(MenuTypeEnum.FUNC.getValue())){
                menuMap.put(menu.getPid(),new ArrayList<>());
            }
            if(menu.getType().equals(MenuTypeEnum.FUNC.getValue())){
                menuMap.get(menu.getPid()).add(item);
            }
            if (menu.getType().equals(MenuTypeEnum.MENU.getValue())){
                checkItems.add(item);
            }
        });
        checkItems.stream().forEach(menu->{
            if(menuMap.get(menu.getMenuId())!=null){
                menu.setFunction(menuMap.get(menu.getMenuId()));
            }
        });
        return checkItems;
    }

    @Override
    public Boolean checkCode(String code) {
        Boolean result = redisUtil.hmGet("MenuCodeStore",code)!=null;
        if(!result){
            result = this.getOne(Wrappers.<SysMenu>lambdaQuery().eq(SysMenu::getPermission,code))!=null;
            if(result){
                redisUtil.hmSet("MenuCodeStore",code,code);
            }
        }
        return result;
    }
}
