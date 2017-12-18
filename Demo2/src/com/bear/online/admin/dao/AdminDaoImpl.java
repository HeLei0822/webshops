package com.bear.online.admin.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bear.online.entity.Admin;
import com.bear.online.entity.Order;
import com.bear.online.entity.Watch;

@Repository
public class AdminDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	
	public Admin login(String username,String password) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Admin a where a.adminName=? and a.adminPwd=?");
		query.setParameter(0,username);
		query.setParameter(1,password);
		return (Admin) query.uniqueResult();
	}
	
	public List<Watch> findAll(){
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Watch");
		return query.list();
	}
	
	public Watch findById(int id) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Watch where id=?");
		query.setParameter(0,id);
		return (Watch) query.uniqueResult();
	}
	
	public boolean updateWatchs(Watch watch) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("update Watch set name=?,nuitPrice=?,listimg=?,img1=?,img2=?,img3=?,introduce=?,watchId=?");
		query.setParameter(0,watch.getName());
		query.setParameter(1,watch.getUnitPrice());
		query.setParameter(2,watch.getListimg());
		query.setParameter(3,watch.getImg1());
		query.setParameter(4,watch.getImg2());
		query.setParameter(5,watch.getImg3());
		query.setParameter(6,watch.getIntroduce());
		query.setParameter(7,watch.getWatchId());
		return query.executeUpdate() > 0;
	}
	
	public boolean addWatchs(Watch watch) {
		this.sessionFactory.getCurrentSession().save(watch);
		return true;
	}
	
	public boolean deleteWatchs(int id){
		Query query = this.sessionFactory.getCurrentSession().createQuery("delete Watch where id=?");
		query.setParameter(0,id);
		return query.executeUpdate() > 0;
	}
	
	public List<Order> findAllOrder(){
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Order");
		return query.list();
	}
	
	public boolean adminDeleteOrder(int orderId) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("delete from Order where orderId=?");
		query.setParameter(0,orderId);
		int i = query.executeUpdate();
		if(i > 0) {
			return true;
		}
		return false;
	}
	
	public boolean adminUpdateOrder(int orderId) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("update Order set state=? where orderId=?");
		query.setParameter(0,"ÒÑ´¦Àí");
		query.setParameter(1,orderId);
		int i = query.executeUpdate();
		if(i > 0) {
			return true;
		}
		return false;
	}

}