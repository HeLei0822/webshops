package com.bear.online.user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bear.online.entity.User;

@Repository
public class UserDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	public List<User> findAll(){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from User");
		return q.list();
	}
	
	public User login(String username,String password){
		Query query = this.sessionFactory.getCurrentSession().createQuery("from User where userName=? and userPwd=?");
		query.setParameter(0,username);
		query.setParameter(1,password);
		User user = (User) query.uniqueResult();
		if(user!=null) {
			return user;
		}else {
			System.out.println("userlogin Dao竃危。。。。。。。。。。。。。。。。。");
			return null;
		}
	}
	
	public User findUserByUserName(String userName) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("fron User where userName=?");

		return (User) query.uniqueResult();
	}
}
