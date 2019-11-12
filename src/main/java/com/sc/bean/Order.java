package com.sc.bean;

public class Order {
	private int oid;
	private int uid;
	private String uname;
	private String utel;
	private String uaddress;
	private int iid;//��Ʒ���
	private String iname;
	private float iprice;
	private int inumber;//��Ʒ����
	private float isum;//��Ʒ�ܼ�
	private String iphoto;//��ƷͼƬ
	private String oshopDate;//��������
	private String oisSend;//�Ƿ��ͻ�,0:��;1:��
	private String osendDate;//��������
	private String oisReceive;//�Ƿ��ջ�,0:��;1:��
	private String oreceiveDate;//�ջ�����
	
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
