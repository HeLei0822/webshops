package com.bear.online.watch.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.bear.online.entity.Watch;
@Component
@Repository
public class WatchDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	
	public List<Watch> findAll(){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from Watch");
		return q.list();
	}
	public List<Watch> findById(){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from Watch where id = ?");
		return q.list();
	}


	
}
