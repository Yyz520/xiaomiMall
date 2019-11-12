package com.sc.bean;

public class Page {

	private int pageNum=1;//��ǰҳ��
	private int pageSize=5;//ÿҳ��ʾ����
	private int pageCount;//������
	private int pageSum;//��ҳ��
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
		//Ҫ������������ÿҳ��ʾ����
		pageSum=pageCount%pageSize==0 ?pageCount/pageSize:(pageCount/pageSize+1);
		return pageSum;
	}
	public void setPageSum(int pageSum) {
		this.pageSum = pageSum;
	}
	
}
