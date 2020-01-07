package com.demo.mybatis.mapper;

import com.demo.mybatis.pojo.UserCopy;

public interface UserCopyMapper {
    int deleteByPrimaryKey(Integer id1);

    int insert(UserCopy record);

    int insertSelective(UserCopy record);

    UserCopy selectByPrimaryKey(Integer id1);

    int updateByPrimaryKeySelective(UserCopy record);

    int updateByPrimaryKey(UserCopy record);
}