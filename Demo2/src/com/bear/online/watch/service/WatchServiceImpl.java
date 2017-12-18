package com.bear.online.watch.service;




import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bear.online.entity.Order;
import com.bear.online.entity.Watch;
import com.bear.online.entity.WatchType;
import com.bear.online.watch.dao.WatchDaoImpl;

@Service
@Transactional(readOnly=true)
public class WatchServiceImpl {
	@Resource
	private WatchDaoImpl watchDaoImpl;
	
	public List<Watch> listAll(){
		return this.watchDaoImpl.findAll();
	}
	
	public Watch findById(int id){
		 return this.watchDaoImpl.findById(id);
		
	}
	
	public List<WatchType> allWatchType(){
		 return this.watchDaoImpl.allWatchType();
	}
	
	public int totalPages() {
		return this.watchDaoImpl.totalPages();
	}
	
	public List<Watch> findAllWatch(Integer pages){
		return this.watchDaoImpl.findAllWatch(pages);
	}
	
	public List<Watch> findWatchTypeById(int id){
		return this.watchDaoImpl.findWatchTypeById(id);
	}
	
	public String findWatchTypeName(int id) {
		return this.watchDaoImpl.findWatchTypeName(id);
	} 
	
	public boolean addWatch(String userId,int id,int count,int unitPrice,Date date) {
		return this.watchDaoImpl.addWatch(userId,id,count,unitPrice,date);
	}
	
	public List<Order> findShoppingcart(String userId){
		return this.watchDaoImpl.findShoppingcart(userId);
	}

	public boolean deleteWatch(String userId,int id) {
		return this.watchDaoImpl.deleteWatch(userId,id);
	}
	
	public boolean updateOrder(String userId,int id) {
		return this.watchDaoImpl.updateOrder(userId, id);
	}
	
	public List<Order> findAllOrder(String userId){
		return this.watchDaoImpl.findAllOrder(userId);
	}
	
	public Order findOrders(String userId,int id) {
		return this.watchDaoImpl.findOrders(userId, id);
	}

	public boolean downWatch(String userId,int id) {
		return this.watchDaoImpl.downWatch(userId,id);
	}
	
}
