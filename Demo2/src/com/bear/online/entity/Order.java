package com.bear.online.entity;

import java.util.Date;

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
@Table(name="order")
public class Order {
	private int orderId;
	private String addr;
	private Date orderdate;
	private User userId;
	private Orderitem orderitemId;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	
	@ManyToOne
	@JoinColumn(name="userId")
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	@OneToOne
	@JoinColumn(name="orderitemId")
	public Orderitem getOrderitemId() {
		return orderitemId;
	}
	public void setOrderitemId(Orderitem orderitemId) {
		this.orderitemId = orderitemId;
	}
}
