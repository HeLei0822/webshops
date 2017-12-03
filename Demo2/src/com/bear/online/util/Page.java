package com.bear.online.util;

import java.util.List;

public class Page<Watch> {
	//private List<Watch> list;
	private int totalRecords;//总条数
	private int pageSize;//每页的记录
	private int totalIndex;//进行分页后用多少页
	private int startIndex;//从哪一页开始
	private int currentPage;//用户想从哪一页开始
	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalIndex() {
		return totalIndex;
	}
	public void setTotalIndex(int totalIndex) {
		this.totalIndex = totalIndex;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	private List list = null;
	
	public Page(int pageNum,int totalRecords) {
		this.currentPage = pageNum;
		this.totalRecords = totalRecords;
		
		this.pageSize = 6;
		this.startIndex = (this.currentPage - 1)*this.pageSize;
		if(this.totalRecords % this.pageSize == 0) {
			this.totalIndex = this.totalRecords / this.pageSize;
		}else {
			this.totalIndex = this.totalRecords / this.pageSize + 1;
		}
	}
}
