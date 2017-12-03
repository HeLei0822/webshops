package com.bear.online.watch.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bear.online.entity.Watch;
import com.bear.online.watch.service.WatchServiceImpl;

@Controller
@RequestMapping("watch")
public class WatchController {
	@Resource
	private WatchServiceImpl watchServiceImpl;
	@RequestMapping("/products")
	public String list(Model model) {
		List<Watch> list = this.watchServiceImpl.listAll();
		model.addAttribute("list",list);
		return "front/products";
	}
	
//	@RequestMapping("/productsDetail")
//	public String show(Model model) {
//		List<Watch> lists = this.watchServiceImpl.listById();
//		model.addAttribute("lists",lists);
//		return "front/productsDetail";
//	}
	
	public String show(HttpServletRequest request,HttpServletResponse response,Model model) {
		request.getParameter("id");
		Watch watch = new Watch();
		watch
		return "front/productsDetail";
	}
}
