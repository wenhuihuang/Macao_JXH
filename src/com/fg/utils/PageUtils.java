package com.fg.utils;

import java.util.List;

public class PageUtils<T> {
	private int pageSize;
	private int totalPage;
	private int currentPage;
	private int rowCount;
	private List<T> list;

	public PageUtils() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PageUtils(int pageSize, int totalPage, int currentPage, int rowCount) {
		super();
		this.pageSize = pageSize;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
		this.rowCount = rowCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return rowCount%pageSize==0?rowCount/pageSize:(rowCount/pageSize)+1;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	
	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "PageUtils [pageSize=" + pageSize + ", totalPage=" + totalPage + ", currentPage=" + currentPage
				+ ", rowCount=" + rowCount + ", list=" + list + "]";
	}

	

}
