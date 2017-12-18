package com.bear.online.admin.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bear.online.admin.service.AdminServiceImpl;
import com.bear.online.entity.Admin;
import com.bear.online.entity.Order;
import com.bear.online.entity.Watch;
import com.bear.online.watch.service.WatchServiceImpl;

@Controller
public class AdminController {
	@Resource
	private AdminServiceImpl adminServiceImpl;
	private WatchServiceImpl watchServiceImpl;
	
	@RequestMapping("/adminlogin")
	public String login(HttpSession session,String username,String password,Model model) {
		Admin admin = this.adminServiceImpl.login(username, password);
		if(admin == null) {
			return "backstage/login";
		}else {
			model.addAttribute("admin",admin);
			session.setAttribute("admin",admin);
			return "redirect:adminWatch";
		}
	}
	
	@RequestMapping("/adminWatch")
	public String adminWatch(HttpSession session) {
		List<Watch> list = this.adminServiceImpl.ListAll();
		session.setAttribute("adminWatch",list);
		return "backstage/adminWatch";
	}
	
	@RequestMapping("/adminFindById")
	public String findById(HttpSession session,int id,Model model) {
		Watch watch = this.adminServiceImpl.findById(id);
		model.addAttribute("adminWatch",watch);
		session.setAttribute("adminWatch",watch);
		return "redirect:adminWatchUpdate";
	}
	
	@RequestMapping("/adminWatchUpdate")
	public String adminWatchUpdate(Watch watch) {
		boolean watch1 = this.adminServiceImpl.updateWatchs(watch);
		return "redirect:adminWatch";
	}
	
	@RequestMapping("/adminWatchAdd")
	public String adminWatchAdd(Watch watch) {
		boolean result = this.adminServiceImpl.addWatchs(watch);
		return "redirect:adminWatch";
	}
	
	@RequestMapping("/adminWatchDelete")
	public String adminWatchDelete(int id) {
		boolean result = this.adminServiceImpl.deleteWatchs(id);
		return "backstage/adminWatch";
	}
	
	@RequestMapping("/adminOrderList")
	public String adminOrderList(Model model) {
		List<Order> orderList = this.adminServiceImpl.findAllOrder();
		model.addAttribute("orderList",orderList);
		return "backstage/adminOrderList";
	}
	
	@RequestMapping("/adminDeleteOrder")
	public String adminDeleteOrder(int orderId) {
		boolean delete = this.adminServiceImpl.adminDeleteOrder(orderId);
		if(delete == true) {
			return "redirect:adminOrderList";
		}else {
			System.out.println("¶©µ¥É¾³ýÊ§°Ü");
			return "redirect:adminOrderList";
		}
	}
	
	@RequestMapping("/adminUpdateOrder")
	public String adminUpdateOrder(int orderId,String stage,Model model) {
		System.out.println(stage);
		if(stage.equals("Î´´¦Àí")) {
			this.adminServiceImpl.adminUpdateOrder(orderId);
			return "redirect:adminOrderList";
		}
		return "redirect:adminOrderList";
	}
}
