package com.axisx.serviceuac.service;

import com.axisx.apiuac.dto.*;
import com.axisx.apiuac.vo.UserVO;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @author Axisx
 */
public interface UserService {

    UserDetailDTO getCurrent();

    UserDetailDTO getUserDetail(String username);

    UserVO getUser(Integer id);

    IPage<UserVO> listUser(ListUserDTO listUserDTO);

    UserVO saveUser(SaveUserDTO saveUserDTO);

    Boolean removeUser(Integer id);

    UserVO updateUser(UpdateUserDTO updateUserDTO);

    Boolean checkUsername(String username);

}
