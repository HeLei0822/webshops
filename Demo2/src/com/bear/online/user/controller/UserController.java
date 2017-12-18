package com.bear.online.user.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bear.online.entity.User;
import com.bear.online.entity.Watch;
import com.bear.online.entity.WatchType;
import com.bear.online.user.service.UserServiceImpl;
import com.bear.online.watch.service.WatchServiceImpl;

@Controller
@RequestMapping("user")
public class UserController {
	
	private static List<User> userList;
	public UserController() {
		super();
		userList = new ArrayList<User>();
	}
	
	@Resource
	private UserServiceImpl userServiceImpl;
	private WatchServiceImpl watchServiceImpl;
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request,HttpServletResponse response,Model model) {
		User user2 = new User();
		String username2;
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null) {
			String username = request.getParameter("userName");
			String password = request.getParameter("userPwd");
			User user = this.userServiceImpl.login(username, password);
			user2 = user;
			username2 = username;
		}else {
			String username = (String)session.getAttribute("user");
			User user = this.userServiceImpl.findUserByUserName(username);
			user2 = user;
			username2 = username;
		}
		List<Watch> list = this.watchServiceImpl.listAll();
		int min = 1;
		int max = 5;
		Random random = new Random();
		
		int s1 = random.nextInt(max)%(max - min + 1) + min;
		List<Watch> list1 = new ArrayList<Watch>();
		for(int i = 0;i < 6;i++) {
			Watch watch = list.get(i);
			list1.add(watch);
		}
		Watch watch2 = list1.get(s1);
		model.addAttribute("watch2",watch2);
		List<WatchType> list2 = this.watchServiceImpl.allWatchType();
		model.addAttribute("list2",list2);
		if(user2 != null) {
			model.addAttribute("list",list1);
			session.setAttribute("user",username2);
			return "front/index";
		}else {
			model.addAttribute("errormsg","用户名或密码错误");
			return "front/register";
		}
		
	}
	
	
	@RequestMapping("/register")
	public String register(@RequestParam("userId") String userId,@RequestParam("userName") String userName,
			@RequestParam("email") String email,@RequestParam("phone") String phone,@RequestParam("addr") String addr,
			@RequestParam("userPwd") String userPwd,@RequestParam("userPwd1") String userPwd1,Model model) {
		User user = new User();
		user.setUserId(userId);
		user.setUserName(userName);
		user.setEmail(email);
		user.setPhone(phone);
		user.setAddr(addr);
		user.setUserPwd(userPwd);
		user.setUserPwd1(userPwd1);
		userList.add(user);
		model.addAttribute("userList",userList);
		return "front/login";
	}	
		

		@RequestMapping("/userList")
		public String list(Model model) {
			List<User> list = this.userServiceImpl.listAll();
			model.addAttribute("list",list);
			return "front/userList"; 
	}
}
