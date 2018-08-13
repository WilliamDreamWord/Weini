package com.paopao.dao;

import com.paopao.po.Package;
import org.apache.ibatis.annotations.Param;

public interface PackageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Package record);

    int insertSelective(Package record);

    Package selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Package record);

    int updateByPrimaryKeyWithBLOBs(Package record);

    int updateByPrimaryKey(Package record);

    int updateStatus(@Param("id") int id, @Param("status") int status);
}