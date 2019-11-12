package com.sc.bean;

public class Page {

	private int pageNum=1;//当前页数
	private int pageSize=5;//每页显示条数
	private int pageCount;//总条数
	private int pageSum;//总页数
	public Page() {
		super();
	}
	public Page(int pageNum, int pageSize, int pageCount, int pageSum) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
		this.pageSum = pageSum;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageSum() {
		//要设置总条数和每页显示条数
		pageSum=pageCount%pageSize==0 ?pageCount/pageSize:(pageCount/pageSize+1);
		return pageSum;
	}
	public void setPageSum(int pageSum) {
		this.pageSum = pageSum;
	}
	
}
