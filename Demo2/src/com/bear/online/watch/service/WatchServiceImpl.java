package com.bear.online.watch.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bear.online.entity.Watch;
import com.bear.online.util.Page;
import com.bear.online.watch.dao.WatchDaoImpl;

@Service
@Transactional(readOnly=true)
public class WatchServiceImpl {
	@Resource
	private WatchDaoImpl watchDaoImpl;
	public List<Watch> listAll(){
		return this.watchDaoImpl.findAll();
	}
	
	public List<Watch> listById(){
		return this.watchDaoImpl.findById();
	}
	
//	public Page queryForPage(int currentPage,int pageSize) {
//		Page page = new Page();
//		int allRow = this.watchDaoImpl.getAllRowCount();
//		int offset = page.countOffset(currentPage,pageSize);
//		List<Watch> list = this.watchDaoImpl.findAll();
//		page.setPageNo(currentPage);
//		page.setPageSize(pageSize);
//		page.setTotalRecords(allRow);
//		page.setList(list);
//		return page;
//		
//	}
}
