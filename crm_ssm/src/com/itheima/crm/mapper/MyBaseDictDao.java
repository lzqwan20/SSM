package com.itheima.crm.mapper;

import java.util.List;

import com.itheima.crm.pojo.BaseDict;

public interface MyBaseDictDao {
	public List<BaseDict> selectBaseListByCode(String code);
}
