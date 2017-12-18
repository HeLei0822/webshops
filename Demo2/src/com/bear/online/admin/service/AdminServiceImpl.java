package com.bear.online.admin.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bear.online.admin.dao.AdminDaoImpl;
import com.bear.online.entity.Admin;
import com.bear.online.entity.Order;
import com.bear.online.entity.Watch;

@Service
@Transactional(readOnly=true)
public class AdminServiceImpl {
	@Resource
	private AdminDaoImpl adminDaoImpl;
	
	public Admin login(String username,String password) {
		return this.adminDaoImpl.login(username, password);
	}
	
	public List<Watch> ListAll(){
		return this.adminDaoImpl.findAll();
	}
	
	public Watch findById(int id) {
		return this.adminDaoImpl.findById(id);
	}
	
	public boolean updateWatchs(Watch watch) {
		return this.adminDaoImpl.updateWatchs(watch);
	}
	
	public boolean addWatchs(Watch watch) {
		return this.adminDaoImpl.addWatchs(watch);
	}
	
	public boolean deleteWatchs(int id) {
		return this.adminDaoImpl.deleteWatchs(id);
	}
	
	public List<Order> findAllOrder(){
		return this.adminDaoImpl.findAllOrder();
	}
	
	public boolean adminDeleteOrder(int orderId) {
		return this.adminDaoImpl.adminDeleteOrder(orderId);
	}
	
	public boolean adminUpdateOrder(int orderId) {
		return this.adminDaoImpl.adminUpdateOrder(orderId);
	}
}
