package com.bear.online.util;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional(readOnly=true)
public class PageServiceIImpl {
	@Resource
	private PageDaoImpl pageDaoImpl;
	
	public int getTotalRecords() {
		return this.pageDaoImpl.getTotalPage();
		
	}
}
