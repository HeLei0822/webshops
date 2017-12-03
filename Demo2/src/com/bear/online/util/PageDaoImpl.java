package com.bear.online.util;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PageDaoImpl {
	@Resource
   private SessionFactory sessionfactory;
	


	public int getTotalPage() {
		// TODO Auto-generated method stub
		Query q = this.sessionfactory.getCurrentSession().createQuery("from count(Id) from Watch");
		return (int) q.uniqueResult();
	}
}
