package com.bear.online.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bear.online.entity.User;
import com.bear.online.user.dao.UserDaoImpl;

@Service
@Transactional(readOnly=true)
public class UserServiceImpl {
	
	@Resource
	private UserDaoImpl userDaoImpl;
	public List<User> listAll(){
		return this.userDaoImpl.findAll();
	}
	
	public User login(String username,String password) {
		User user = this.userDaoImpl.login(username, password);
		return user;
	}
	
	public User findUserByUserName(String userName) {
		return this.userDaoImpl.findUserByUserName(userName);
	}
}
