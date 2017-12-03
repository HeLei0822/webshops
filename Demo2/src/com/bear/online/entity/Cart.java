package com.bear.online.entity;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {
	private int cartId;
	private String name;
	private String Listimg;
	private int unitPrice;
	private int count;
	private String color;
	private User user;
	private Set<Watch> watchSet = new HashSet<Watch>();
	@Id
	@Column(name="cartId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getListimg() {
		return Listimg;
	}
	public void setListimg(String listimg) {
		Listimg = listimg;
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	@ManyToOne
	@JoinColumn(name="userId")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id")
	public Set<Watch> getWatchSet() {
		return watchSet;
	}
	public void setWatchSet(Set<Watch> watchSet) {
		this.watchSet = watchSet;
	}

}
