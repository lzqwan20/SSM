package com.gzucm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.gzucm.dao.UserDao;
import com.gzucm.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public User login(User user) {
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where user_code=? and user_password = ?", user.getUser_code(),user.getUser_password());
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void saveUser(User user) {
		this.getHibernateTemplate().save(user);
		
	}

}
