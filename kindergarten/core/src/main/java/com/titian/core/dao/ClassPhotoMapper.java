package com.titian.core.dao;

import com.titian.core.domain.ClassPhoto;

public interface ClassPhotoMapper {
    int deleteByPrimaryKey(Integer albumId);

    int insert(ClassPhoto record);

    int insertSelective(ClassPhoto record);

    ClassPhoto selectByPrimaryKey(Integer albumId);

    int updateByPrimaryKeySelective(ClassPhoto record);

    int updateByPrimaryKey(ClassPhoto record);
}