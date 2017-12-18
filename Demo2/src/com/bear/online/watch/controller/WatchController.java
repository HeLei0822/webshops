package com.bear.online.watch.controller;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.mapping.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bear.online.entity.Cart;
import com.bear.online.entity.Order;
import com.bear.online.entity.User;
import com.bear.online.entity.Watch;
import com.bear.online.entity.WatchType;
import com.bear.online.user.service.UserServiceImpl;
import com.bear.online.watch.service.WatchServiceImpl;

@Controller
@RequestMapping("watch")
public class WatchController {
	@Resource
	private WatchServiceImpl watchServiceImpl;
	private UserServiceImpl userServiceImpl;
	
	/**
	 * 
	 * @param pages 请求的页数
	 * @param model
	 * @return
	 */
	@RequestMapping("/products")
	public String list(Integer pages,Model model) {
		int totalPages = this.watchServiceImpl.totalPages();
		if(pages == null) {
			pages = 1;
		}
		if(pages < 1) {
			pages = 1;
		}
		if(pages > totalPages) {
			pages = totalPages;
		}
		
		List<Watch> list = this.watchServiceImpl.findAllWatch(pages);
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getIntroduce().length()>45) {
				String introduce = list.get(i).getIntroduce().substring(0,45)+"...";
				list.get(i).setIntroduce(introduce);
			}
		}
		if(list!=null) {
			model.addAttribute("list",list);
			model.addAttribute("totalPages",totalPages);
			model.addAttribute("pages",pages);
			return "front/products";
		}
		return "front/products";
	}
	
	@RequestMapping("/productsDetail")
	public String findById(int id,Model model) {
		Watch watch = this.watchServiceImpl.findById(id);
		int min = 100;
		int max = 200;
		Random random = new Random();
		int s = random.nextInt(max)%(max-min+1)+min;
		model.addAttribute("s1",s);
		model.addAttribute("s2",s);
		if(watch != null) {
			model.addAttribute("watch",watch);
			return "front/productsDetail";
		}
		
		return "redirect:typeWatch";
	}
	
	@RequestMapping("/typeWatch")
	public String typeWatch(HttpServletRequest request,HttpServletResponse response, int id,Model model) {
		String id1 = request.getParameter("id");
		response.setContentType("text/html");
		List<Watch> list = this.watchServiceImpl.findWatchTypeById(id);
		String watchName = this.watchServiceImpl.findWatchTypeName(id);
		if(list != null) {
			model.addAttribute("list",list);
			model.addAttribute("watchName",watchName);
			return "front/productsDetail";
		}
		return "front/watchType";
	}
	
	@RequestMapping("/bookType")
	public String watchType(Model model) {
		List<WatchType> list = this.watchServiceImpl.allWatchType();
		if(list != null) {
			model.addAttribute("list",list);
			return "front/watchType";
		}else {
			return "redirect:products";
		}
		
	}
	
	@RequestMapping("/addShoppingcart")
	public String addShoppingCart(HttpServletRequest request,Model model, int id ) {
		String count = request.getParameter("count");
		String color = request.getParameter("color");
		String size = request.getParameter("size");
		
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		
		DateFormat d1 = DateFormat.getDateInstance();
		String str1 = d1.format(date);
		DateFormat d2 = DateFormat.getDateInstance();
		String str2 = d2.format(date);
		DateFormat d3 = DateFormat.getTimeInstance();
		String str3 = d3.format(date);
		DateFormat d5 = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL); 
	    String str5 = d5.format(date);
	    DateFormat d6 = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG); 
	    String str6 = d6.format(date);
	    DateFormat d7 = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT); 
	    String str7 = d7.format(date);
	    DateFormat d8 = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM); 
	    String str8 = d8.format(date);
	    DateFormat d9 = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM); 
	    String str9 = d9.format(date);
	    
	    HttpSession session = request.getSession();
	    String userName = (String) session.getAttribute("user");
	    User user = this.userServiceImpl.findUserByUserName(userName);
	    String userId = user.getUserId();
	    Watch watch = this.watchServiceImpl.findById(id);
	    int unitPrice = watch.getUnitPrice();
	    int count1 = Integer.parseInt(count);
	    
	    
		boolean a = this.watchServiceImpl.addWatch(userId,id,count1,unitPrice,date);
		if(a == true) {
			return "redirect:shoppingcart";
		}
		return "redirect:productsDetail";
	}
	
	@RequestMapping("/shoppingcart")
	public String shoppingcart(HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("user");
		User user = this.userServiceImpl.findUserByUserName(username);
		String userId = user.getUserId();
		List<Order> list = this.watchServiceImpl.findShoppingcart(userId);
		
		if(list != null) {
			model.addAttribute("list",list);
			model.addAttribute("username",username);
			HashMap map = new HashMap();
			for(int i=0;i<list.size();i++) {
				int id = list.get(i).getId();
				Watch watch = this.watchServiceImpl.findById(id);
				String name = watch.getName();
				map.put(name,list.get(i));
			}
			model.addAttribute("map",map);
			return "front/shoppingcart";
		}
		return "front/shoppingcart";
	}
	
	@RequestMapping("/deleteWatch")
	public String deleteWatch(HttpServletRequest request,int id,Model model) {
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("user");
		User user = this.userServiceImpl.findUserByUserName(username);
		String userId = user.getUserId();
		boolean a = this.watchServiceImpl.deleteWatch(userId,id);
		if(a) {
			return "redirect:shoppingcart";
		}
		return "redirect:shoppingcart";
	}
	
	@RequestMapping("/deleteAll")
	public String deleteAll(HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("user");
		User user = this.userServiceImpl.findUserByUserName(username);
		String userId = user.getUserId();
		String[] list = request.getParameterValues("delete");
		for(int i=0;i<list.length;i++) {
			int id = Integer.parseInt(list[i]);
			model.addAttribute("watch",list[i]);
			boolean a = this.watchServiceImpl.deleteWatch(userId, id);
			if(a) {
				continue;
			}else {
				break;
			}
		}
		return "redirect:shoppingcart";
	}
	
	@RequestMapping("/order")
	public String Order(HttpServletRequest request,int id,Model model) {
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("user");
		User user = this.userServiceImpl.findUserByUserName(username);
		String userId = user.getUserId();
		Watch watch = this.watchServiceImpl.findById(id);
		int unitPrice= watch.getUnitPrice();
		boolean a =this.watchServiceImpl.updateOrder(userId,id);
		
		if(a) {
			return "redirect:orders";
		}else {
			return "redirect:shoppingcart";
		}
	}
	
	@RequestMapping("/orders")
	public String orders(HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		User user = this.userServiceImpl.findUserByUserName(username);
		String userId = user.getUserId();
		List<Order> list = this.watchServiceImpl.findAllOrder(userId);
		if(list != null) {
			model.addAttribute("list",list);
			model.addAttribute("username",username);
			HashMap map = new HashMap();
			for(int i=0;i < list.size();i++) {
				int id = list.get(i).getId();
				Watch watch = this.watchServiceImpl.findById(id);
				String name = watch.getName();
				map.put(name,list.get(i));
			}
			model.addAttribute("map",map);
			return "front/order";
		}else {
			model.addAttribute("error","还没有商品");
			return "front/order";
		}
	}
	
	@RequestMapping("/orderDetail")
	public String orderDetail(HttpServletRequest request, int id,Model model) {
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("user");
		User user = this.userServiceImpl.findUserByUserName(username);
		String userId = user.getUserId();
		Order order =this.watchServiceImpl.findOrders(userId,id);
		if(order != null) {
			Watch watch = this.watchServiceImpl.findById(id);
			model.addAttribute("user1",user);
			model.addAttribute("watch",watch);
			model.addAttribute("order",order);
			int min = 1000000000;
			int max = 1100000000;
			Random random = new Random();
			int s1 = random.nextInt(max)%(max-min+1);
			model.addAttribute("s1",s1);
			return "front/OrderDetail";
		}
		return "front/order";
		
	}
	
	@RequestMapping("/downWatch")
	public String downWatch(HttpServletRequest request, int id,Model model) {
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("user");
		User user = this.userServiceImpl.findUserByUserName(username);
		String userId = user.getUserId();
		boolean a = this.watchServiceImpl.downWatch(userId,id);
		if(a) {
			return "redirect:orders";
		}
		return "redirect:orders";
	}
	
	
}
