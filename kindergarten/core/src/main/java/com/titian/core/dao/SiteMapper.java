package com.titian.core.dao;

import com.titian.core.domain.Site;

import java.util.List;
import java.util.Map;

public interface SiteMapper {

    int deleteByPrimaryKey(Integer siteId);

    int insert(Site record);

    int insertSelective(Site record);

    Site selectByPrimaryKey(Integer siteId);

    List<Site> selectByName(Map<String, String> param);

    int updateByPrimaryKeySelective(Site record);

    int updateByPrimaryKey(Site record);
}