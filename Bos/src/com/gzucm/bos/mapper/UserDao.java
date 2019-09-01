package com.gzucm.bos.mapper;

import com.gzucm.bos.pojo.User;

public interface UserDao {
	public User login(User user);

	public void editPassword(String password, String userId);
}
