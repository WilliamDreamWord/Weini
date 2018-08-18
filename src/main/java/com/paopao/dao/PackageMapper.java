package com.paopao.dao;

import com.paopao.po.Package;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PackageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Package record);

    int insertSelective(Package record);

    Package selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Package record);


    int updateByPrimaryKey(Package record);

    int updateStatus(@Param("id") Integer id, @Param("userId") Integer userId,
                     @Param("status") Integer status);

    Package selectByIdAndUserId(@Param("id") Integer id, @Param("userId") Integer userId);

    List<Package> selectList();

    int updateByIdAndUserId(Package record);

    List<Package> selectByUserId(@Param("userId") Integer userId,
                                 @Param("begin") Integer being,
                                 @Param("count") Integer count);



}