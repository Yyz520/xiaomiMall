package com.sc.bean;

public class Order {
	private int oid;
	private int uid;
	private String uname;
	private String utel;
	private String uaddress;
	private int iid;//商品编号
	private String iname;
	private float iprice;
	private int inumber;//商品数量
	private float isum;//商品总价
	private String iphoto;//商品图片
	private String oshopDate;//购买日期
	private String oisSend;//是否送货,0:是;1:否
	private String osendDate;//发货日期
	private String oisReceive;//是否收货,0:是;1:否
	private String oreceiveDate;//收货日期
	
	public Order(int oid, int uid, String uname, String utel, String uaddress, int iid, String iname, float iprice,
			int inumber, float isum, String iphoto, String oshopDate, String oisSend, String osendDate,
			String oisReceive, String oreceiveDate) {
		super();
		this.oid = oid;
		this.uid = uid;
		this.uname = uname;
		this.utel = utel;
		this.uaddress = uaddress;
		this.iid = iid;
		this.iname = iname;
		this.iprice = iprice;
		this.inumber = inumber;
		this.isum = isum;
		this.iphoto = iphoto;
		this.oshopDate = oshopDate;
		this.oisSend = oisSend;
		this.osendDate = osendDate;
		this.oisReceive = oisReceive;
		this.oreceiveDate = oreceiveDate;
	}

	
	
	
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUtel() {
		return utel;
	}
	public void setUtel(String utel) {
		this.utel = utel;
	}
	public String getUaddress() {
		return uaddress;
	}
	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}
	public int getIid() {
		return iid;
	}
	public void setIid(int iid) {
		this.iid = iid;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public float getIprice() {
		return iprice;
	}
	public void setIprice(float iprice) {
		this.iprice = iprice;
	}
	public int getInumber() {
		return inumber;
	}
	public void setInumber(int inumber) {
		this.inumber = inumber;
	}
	public float getIsum() {
		return isum;
	}
	public void setIsum(float isum) {
		this.isum = isum;
	}
	public String getIphoto() {
		return iphoto;
	}
	public void setIphoto(String iphoto) {
		this.iphoto = iphoto;
	}
	public String getOshopDate() {
		return oshopDate;
	}
	public void setOshopDate(String oshopDate) {
		this.oshopDate = oshopDate;
	}
	public String getOisSend() {
		return oisSend;
	}
	public void setOisSend(String oisSend) {
		this.oisSend = oisSend;
	}
	public String getOsendDate() {
		return osendDate;
	}
	public void setOsendDate(String osendDate) {
		this.osendDate = osendDate;
	}
	public String getOisReceive() {
		return oisReceive;
	}
	public void setOisReceive(String oisReceive) {
		this.oisReceive = oisReceive;
	}
	public String getOreceiveDate() {
		return oreceiveDate;
	}
	public void setOreceiveDate(String oreceiveDate) {
		this.oreceiveDate = oreceiveDate;
	}


}
