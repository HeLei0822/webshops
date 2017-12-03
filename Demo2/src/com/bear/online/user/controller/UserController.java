package com.bear.online.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bear.online.entity.User;
import com.bear.online.entity.Watch;
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
	
	@RequestMapping("/login")
	public String login(@RequestParam("userId") String userId,@RequestParam("userPwd") String userPwd,Model model) {
		if(userId.equals("123")&& userPwd.equals("123")) {
			model.addAttribute("userId",userId);
			return "front/index";
		}else {
			model.addAttribute("userId",userId);
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
