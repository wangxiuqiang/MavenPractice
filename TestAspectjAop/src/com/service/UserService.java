package com.service;

import com.dao.UserDao;

public class UserService {

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void acountMoney(){
		
		userDao.lessMoney();
		
	    int i = 5/0;
	   
		
		userDao.moreMoney();
		
	}
	
}
