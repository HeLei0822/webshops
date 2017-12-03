package com.bear.online.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="orderitem")
public class Orderitem {
	private int orderitemId;
	private int unitPrice;
	private int count;
	private String name;
	private Order order;
	private Watch watch;
	@Id
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getOrderitemId() {
		return orderitemId;
	}
	public void setOrderitemId(int orderitemId) {
		this.orderitemId = orderitemId;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@OneToOne
	@JoinColumn(name="orderId")
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	@ManyToOne
	@JoinColumn(name="id")
	public Watch getWatch() {
		return watch;
	}
	public void setWatch(Watch watch) {
		this.watch = watch;
	}
	
}
