package com.x2era.flow.service;

import com.github.pagehelper.PageInfo;
import com.x2era.flow.bean.User;

public interface IUserService {

    PageInfo<User> selectUserList(User user, Integer pageNum);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int deleteUser(Integer userId);

    User queryUserByUserAccountandPassword(String userAccount, String userPassword);

}
