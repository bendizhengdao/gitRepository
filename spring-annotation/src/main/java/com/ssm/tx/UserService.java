package com.ssm.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Transactional(rollbackFor=Exception.class)
	public void insert(){
		userDao.insert();
		int i = 1/0;
	}
}
