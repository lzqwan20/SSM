package com.gzucm.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.gzucm.dao.UserDao;
import com.gzucm.domain.User;
import com.gzucm.service.UserService;
import com.gzucm.utils.MD5Utils;
@Transactional
public class UserServiceImpl implements UserService{
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public User login(User user) {
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		return userDao.login(user);
	}
	@Override
	public void saveUser(User user) {
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		userDao.saveUser(user);
		
	}

}
