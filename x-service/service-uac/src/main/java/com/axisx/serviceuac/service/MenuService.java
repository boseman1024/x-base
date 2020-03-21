package com.axisx.serviceuac.service;

import com.axisx.apiuac.dto.*;
import com.axisx.apiuac.vo.MenuCheckItemVO;
import com.axisx.apiuac.vo.MenuTreeVO;
import com.axisx.apiuac.vo.MenuVO;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * @author Axisx
 */
public interface MenuService {

    List<MenuVO> listMenuByRoleId(Integer id);

    MenuVO getMenu(Integer id);

    IPage<MenuVO> listMenu(ListMenuDTO listMenuDTO);

    MenuVO saveMenu(SaveMenuDTO saveMenuDTO);

    Boolean removeMenu(Integer id);

    MenuVO updateMenu(UpdateMenuDTO updateMenuDTO);

    List<MenuTreeVO> getMenuTree(Integer id);

    List<MenuCheckItemVO> getMenuCheckItem();

    Boolean checkCode(String code);

}
