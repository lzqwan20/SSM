package com.itheima.crm.service;

import java.util.List;

import com.itheima.crm.pojo.BaseDict;

public interface MyBaseDictService {
	public List<BaseDict> selectBaseListByCode(String code);
}
