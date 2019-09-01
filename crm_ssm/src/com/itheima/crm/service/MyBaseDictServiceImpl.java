package com.itheima.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.crm.mapper.MyBaseDictDao;
import com.itheima.crm.pojo.BaseDict;

@Service
public class MyBaseDictServiceImpl implements MyBaseDictService{
	@Autowired
	private MyBaseDictDao mybaseDictDao;
	@Override
	public List<BaseDict> selectBaseListByCode(String code) {
		
		return mybaseDictDao.selectBaseListByCode(code);
	}

}
