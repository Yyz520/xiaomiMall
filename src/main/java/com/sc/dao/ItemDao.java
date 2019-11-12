package com.sc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sc.bean.Item;

public class ItemDao {
	//�������ݿ���ʵĶ���
	Connection conn=null;
	Statement st=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	//��ѯ������Ʒ�б�
	public List<Item> selectItem(){
		List<Item> list=new ArrayList<Item>();
		conn= DataConn.getConn();
		String sql="select * from t_item";
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs!=null&&rs.next()){
				Item i=new Item(rs.getInt("itemId"),
					rs.getString("itemName"),
					rs.getInt("cid"),
					rs.getString("itemProductor"),
					rs.getString("itemPhoto"),
					rs.getString("itemIntro"),
					rs.getFloat("priceVip"),
					rs.getFloat("priceNormal"),
					rs.getInt("itemNum"),
					rs.getInt("itemTolNum"),
					rs.getString("itemState"));
				list.add(i);
			}
		} catch (SQLException e) {
			System.out.println("�������ݿ�ʧ�ܣ�");
		}finally{
			DataConn.closeAll(rs, ps, st, conn);
		}
		return list;
	}
	
	//ͨ����Ʒ�����Ų�ѯ��Ʒ
	public List<Item> getGoodsBycid(int cid){
		List<Item> list=new ArrayList<Item>();
		try {
			conn= DataConn.getConn();//��ȡ����
			st=conn.createStatement();
			String sql="select * from t_item where cid="+cid;
			System.out.println("�����ɹ���");
			rs=st.executeQuery(sql);
			while(rs!=null&&rs.next()){
				Item i=new Item(rs.getInt("itemId"),
					rs.getString("itemName"),
					rs.getInt("cid"),
					rs.getString("itemProductor"),
					rs.getString("itemPhoto"),
					rs.getString("itemIntro"),
					rs.getFloat("priceVip"),
					rs.getFloat("priceNormal"),
					rs.getInt("itemNum"),
					rs.getInt("itemTolNum"),
					rs.getString("itemState"));
				list.add(i);
			}
		}catch (SQLException e) {
			System.out.println("�������ݿ�ʧ�ܣ�");
		}finally {
			//6.�ر����ݿ���Դ
			DataConn.closeAll(rs, ps, st, conn);
		}
		return list;
	}
	
	//ͨ����Ʒ��Ų�ѯ��Ʒ
	public Item getItemById(int itemId){
		Item i=null;
		try {
			conn= DataConn.getConn();//��ȡ����
			//3.ͨ�����Ӷ��󣬴�����������
			st=conn.createStatement();
			//4.ʹ�ó�������ִ�в�ѯ��SQL��䣬���ؽ��������
			String sql="select * from t_item where itemId="+itemId;
			System.out.println("�����ɹ���");
			rs=st.executeQuery(sql);
			//5.ѭ�����������ȡ��������
			while(rs!=null&&rs.next()){
				//ѭ��ȡ��ÿһ�е��е���Ϣ����װ����Ʒ�����������
				i=new Item(rs.getInt("itemId"),
					rs.getString("itemName"),
					rs.getInt("cid"),
					rs.getString("itemProductor"),
					rs.getString("itemPhoto"),
					rs.getString("itemIntro"),
					rs.getFloat("priceVip"),
					rs.getFloat("priceNormal"),
					rs.getInt("itemNum"),
					rs.getInt("itemTolNum"),
					rs.getString("itemState"));
			}
		}catch (SQLException e) {
			System.out.println("�������ݿ�ʧ�ܣ�");
		}finally {
			//6.�ر����ݿ���Դ
			DataConn.closeAll(rs, ps, st, conn);
		}
		return i;
	}
	
		//�޸���Ʒ���
		public void updateitem(int id,int shuliang){				
		try {
			conn= DataConn.getConn();//��ȡ����
		    String sql="update t_item set itemNum=itemNum-? where itemId=?";
		    System.out.println("�����ɹ���");
		    ps=conn.prepareStatement(sql);
		    ps.setInt(1,shuliang);
		    ps.setInt(2,id);
		    ps.executeUpdate();
		 }catch (SQLException e) {
			System.out.println("�������ݿ�ʧ�ܣ�");
		}finally {
			//6.�ر����ݿ���Դ
			DataConn.closeAll(rs, ps, st, conn);
		}
			}
		
		public List<Item> Sou(String s){
			List<Item> list=new ArrayList<Item>();
			System.out.println("s="+s);
			try {
				conn= DataConn.getConn();
			    String sql="select * from t_item where itemName LIKE ? OR itemIntro LIKE ? OR itemProductor LIKE ?";
			    
			    ps=conn.prepareStatement(sql);
			    System.out.println("�����ɹ�2��");
			    ps.setString(1, "%"+s+"%");
			    ps.setString(2, "%"+s+"%");
			    ps.setString(3, "%"+s+"%");
			    rs=ps.executeQuery();			    
			    while(rs!=null&&rs.next()){
			    	//�����ݿ�ȡ��ÿ����Ʒ��Ϣ����װ����Ʒ����
			    	//����ط������ݿ������
			    	Item i=new Item(rs.getInt("itemId"),
							rs.getString("itemName"),
							rs.getInt("cid"),
							rs.getString("itemProductor"),
							rs.getString("itemPhoto"),
							rs.getString("itemIntro"),
							rs.getFloat("priceVip"),
							rs.getFloat("priceNormal"),
							rs.getInt("itemNum"),
							rs.getInt("itemTolNum"),
							rs.getString("itemState"));
			    	list.add(i);//���뼯��
			    }}catch (SQLException e) {
					System.out.println("�������ݿ�ʧ�ܣ�");
				}finally {
					//6.�ر����ݿ���Դ
					DataConn.closeAll(rs, ps, st, conn);
				}			
			return list;
		}
}
