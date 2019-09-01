package com.gzucm.bos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzucm.bos.mapper.UserDao;
import com.gzucm.bos.pojo.User;
import com.gzucm.bos.utils.MD5Utils;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public User login(User user) {
		user.setPassword(MD5Utils.md5(user.getPassword()));
		return userDao.login(user);
	}

	@Override
	public void editPassword(String password, String userId) {
		password = MD5Utils.md5(password);
		userDao.editPassword(password,userId);
	}
}
