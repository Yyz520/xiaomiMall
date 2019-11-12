package com.sc.bean;

public class Item {

	private int itemId;//��Ʒ���
	private String itemName;//��Ʒ����
	private int cid;//��Ʒ����ID��
	private String itemProductor;//��Ʒ������
	private String itemPhoto;
	private String itemIntro;//��Ʒ����
	private float priceVip;
	private float priceNormal;
	private int itemNum;//��Ʒ�����
	private int itemTolNum;//��������Ŀ
	private String itemState;//��Ʒ״̬,0:�ϼ�;1:�¼�
	
	
	public Item() {
	}
	
	public Item(int itemId, String itemName, int cid, String itemProductor, String itemPhoto, String itemIntro,
			float priceVip, float priceNormal, int itemNum, int itemTolNum, String itemState) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.cid = cid;
		this.itemProductor = itemProductor;
		this.itemPhoto = itemPhoto;
		this.itemIntro = itemIntro;
		this.priceVip = priceVip;
		this.priceNormal = priceNormal;
		this.itemNum = itemNum;
		this.itemTolNum = itemTolNum;
		this.itemState = itemState;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getcid() {
		return cid;
	}
	public void setcid(int cid) {
		this.cid = cid;
	}
	public String getItemProductor() {
		return itemProductor;
	}
	public void setItemProductor(String itemProductor) {
		this.itemProductor = itemProductor;
	}
	public String getItemPhoto() {
		return itemPhoto;
	}
	public void setItemPhoto(String itemPhoto) {
		this.itemPhoto = itemPhoto;
	}
	public String getItemIntro() {
		return itemIntro;
	}
	public void setItemIntro(String itemIntro) {
		this.itemIntro = itemIntro;
	}
	public float getPriceVip() {
		return priceVip;
	}
	public void setPriceVip(float priceVip) {
		this.priceVip = priceVip;
	}
	public float getPriceNormal() {
		return priceNormal;
	}
	public void setPriceNormal(float priceNormal) {
		this.priceNormal = priceNormal;
	}
	public int getItemNum() {
		return itemNum;
	}
	public void setItemNum(int itemNum) {
		this.itemNum = itemNum;
	}
	public int getItemTolNum() {
		return itemTolNum;
	}
	public void setItemTolNum(int itemTolNum) {
		this.itemTolNum = itemTolNum;
	}
	public String getItemState() {
		return itemState;
	}
	public void setItemState(String itemState) {
		this.itemState = itemState;
	}
}
