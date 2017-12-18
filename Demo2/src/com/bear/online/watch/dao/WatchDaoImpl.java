package com.bear.online.watch.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.bear.online.entity.Order;
import com.bear.online.entity.Watch;
import com.bear.online.entity.WatchType;

@Repository
public class WatchDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	JdbcTemplate jdbcTemplate;
	
	public List<Watch> findAll(){
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Watch");
		return query.list();
	}
	
	
	public Watch findById(int id){
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Watch where id = ?");
		query.setParameter(0,id);
		return (Watch) query.uniqueResult();
	}
	
	public List<WatchType> allWatchType(){
		Query query = this.sessionFactory.getCurrentSession().createQuery("from WatchType");
		return  query.list();
	}
	
	/**
	 * @return 总的页数
	 */
	int pageSize = 6;
	public int totalPages() {
		Query query = this.sessionFactory.getCurrentSession().createQuery("select count(*) from Watch");
		Long count = (Long) query.uniqueResult();
		int totalPages = 0;
		if(count == pageSize){
			totalPages = 1;
		}
		if(count % pageSize == 0) {
			totalPages = (int)(count / pageSize);
		}
		if(count % pageSize != 0) {
			totalPages = (int)(count / pageSize) + 1;
		}
		return totalPages;
	}


	public List<Watch> findAllWatch(Integer pages){
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Watch");
		query.setFirstResult(pageSize*(pages-1));
		query.setMaxResults(pageSize);
		return query.list();
	}
	
	public String findWatchTypeName(int id){
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Watch where watchId=?");
		query.setParameter(0,id);
		WatchType wt = (WatchType) query.uniqueResult();
		String watchName = wt.getWatchName();
		return watchName;
	}
	
	public List<Watch> findWatchTypeById(int id){
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Watch where watchId=?");
		query.setParameter(0,id);
		return query.list();
	}
	
	public boolean addWatch(String userId,int id,int count,int unitPrice,Date date) {
		java.sql.Date date1 = new java.sql.Date(date.getTime());
		//Query query = this.sessionFactory.getCurrentSession().createQuery("insert into Order(userId,id,state,count,unitPrice,time)values(?,?,?,?,?,?)");
		int i=jdbcTemplate.update("insert into  orders(userId,id,state,count,unitPrice,time)values(?,?,?,?,?,?)",userId,id,"未付款",count,unitPrice,date);
		if(i>0) {
			return true;
		}else {
			return false;
		}
    }

    public List<Order> findShoppingcart(String userId){
    	Query query = this.sessionFactory.getCurrentSession().createQuery("from Order where userId=? and state='未付款'");
    	query.setParameter(0,userId);
    	return query.list();
	}	  
	
	public boolean deleteWatch(String userId,int id) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Order where userId=? and state=? and id = ?");
		query.setParameter(0,"未处理");
		query.setParameter(1,userId);
		query.setParameter(2,id);
		int i = query.executeUpdate();
		if(i > 0) {
			return true;
		}
		return false;
	}
	
	public boolean updateOrder(String userId,int id) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("update Order set state=? where userId=? and id=?");
		query.setParameter(0,"未处理");
		query.setParameter(1,userId);
		query.setParameter(2,id);
		int i = query.executeUpdate();
		if(i > 0) {
			return true;
		}
		return false;
	}
	
	public List<Order> findAllOrder(String userId){
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Order where state='未处理' or state='已处理'");
		return query.list();
	}
	
	public Order findOrders(String userId,int id) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Order where userId=? and id=?");
		query.setParameter(0,userId);
		query.setParameter(1,id);
		return (Order) query.uniqueResult();
	}
	
	public boolean downWatch(String userId,int id) {
		Query query = this.sessionFactory.getCurrentSession().createQuery(" update Order set state='已付款' where userId=? and state=? and id = ?");
		query.setParameter(0,userId);
		query.setParameter(1,id);
		int i = query.executeUpdate();
		if(i > 0) {
			return true;
		}
		return false;
	}
}
