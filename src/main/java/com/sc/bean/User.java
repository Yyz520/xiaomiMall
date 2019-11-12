package com.sc.bean;

public class User {
	private int uid;
	private String uname;
	private String utureName;
	private String upassword;
	private String uidentity;
	private String uemail;
	private String uaddress;
	private String uquestion;
	private String uanswer;
	private String uzipCode;//邮政编码
	private String utel;
	private String uvip;//是否VIP会员,0:是;1:否
	private String uregTime;
	
	public User() {
		super();
	}
	public User(int uid, String uname, String utureName, String upassword, String uidentity, String uemail,
			String uaddress, String uquestion, String uanswer, String uzipCode, String utel, String uvip,
			String uregTime) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.utureName = utureName;
		this.upassword = upassword;
		this.uidentity = uidentity;
		this.uemail = uemail;
		this.uaddress = uaddress;
		this.uquestion = uquestion;
		this.uanswer = uanswer;
		this.uzipCode = uzipCode;
		this.utel = utel;
		this.uvip = uvip;
		this.uregTime = uregTime;
	}
	public int getuid() {
		return uid;
	}
	public void setuid(int uid) {
		this.uid = uid;
	}
	public String getuname() {
		return uname;
	}
	public void setuname(String uname) {
		this.uname = uname;
	}
	public String getutureName() {
		return utureName;
	}
	public void setutureName(String utureName) {
		this.utureName = utureName;
	}
	public String getupassword() {
		return upassword;
	}
	public void setupassword(String upassword) {
		this.upassword = upassword;
	}
	public String getuidentity() {
		return uidentity;
	}
	public void setuidentity(String uidentity) {
		this.uidentity = uidentity;
	}
	public String getuemail() {
		return uemail;
	}
	public void setuemail(String uemail) {
		this.uemail = uemail;
	}
	public String getuaddress() {
		return uaddress;
	}
	public void setuaddress(String uaddress) {
		this.uaddress = uaddress;
	}
	public String getuquestion() {
		return uquestion;
	}
	public void setuquestion(String uquestion) {
		this.uquestion = uquestion;
	}
	public String getuanswer() {
		return uanswer;
	}
	public void setuanswer(String uanswer) {
		this.uanswer = uanswer;
	}
	public String getuzipCode() {
		return uzipCode;
	}
	public void setuzipCode(String uzipCode) {
		this.uzipCode = uzipCode;
	}
	public String getutel() {
		return utel;
	}
	public void setutel(String utel) {
		this.utel = utel;
	}
	public String getuvip() {
		return uvip;
	}
	public void setuvip(String uvip) {
		this.uvip = uvip;
	}
	public String geturegTime() {
		return uregTime;
	}
	public void seturegTime(String uregTime) {
		this.uregTime = uregTime;
	}
}

