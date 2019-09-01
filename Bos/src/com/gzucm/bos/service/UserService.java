package com.gzucm.bos.service;

import com.gzucm.bos.pojo.User;

public interface UserService {

	User login(User user);

	void editPassword(String password, String userId);

}
