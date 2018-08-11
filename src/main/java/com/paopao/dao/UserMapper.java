package com.paopao.dao;

import com.paopao.po.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


    int checkUsername(String username);

    User findByUsernamePassword(@Param("username") String username,
                              @Param("password") String password);
}