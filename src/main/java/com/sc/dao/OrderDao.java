package com.sc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sc.bean.Admin;
import com.sc.bean.Item;
import com.sc.bean.Order;


public class OrderDao {

	Connection conn=null;
	Statement st=null;
	PreparedStatement ps=null;
	ResultSet rs=null;

	public void addOrder(Order g) {
		try {
			conn= DBUtil.getConn();
		    String sql="insert into t_order values(null,?,?,?,?,?,?,?,?,?,?,?,?,null,?,null)";
		    System.out.println("Ҫִ�е�sql�����"+sql);
		    ps=conn.prepareStatement(sql);
		    ps.setInt(1, g.getUid());
		    ps.setString(2, g.getUname());
		    ps.setString(3, g.getUtel());
		    ps.setString(4, g.getUaddress());
	        ps.setInt(5, g.getIid());
	        ps.setString(6, g.getIname());
	        ps.setFloat(7, g.getIprice());
	        ps.setInt(8, g.getInumber());
	        ps.setFloat(9, g.getIsum());
	        ps.setString(10, g.getIphoto());
	        ps.setString(11, g.getOshopDate());
	        ps.setString(12,"1");
	        ps.setString(13,"1");
	       
		    ps.executeUpdate();
		    
			} catch (SQLException e) {
				System.out.println("�������ݿ�ʧ��2��");
			} finally {
				//6.�ر����ݿ���Դ
				DBUtil.closeAll(rs, ps, st, conn);
			}		
	}
	
	public List<Order> getOrder() {
		List<Order> list=new ArrayList<Order>();
		try {
			conn= DBUtil.getConn();//��ȡ����
			//3.ͨ�����Ӷ��󣬴�����������
			st=conn.createStatement();
			//4.ʹ�ó�������ִ�в�ѯ��SQL��䣬���ؽ��������
			String sql="select * from t_order";
			System.out.println("�����ɹ���");
			rs=st.executeQuery(sql);
			//5.ѭ�����������ȡ��������
			while(rs!=null&&rs.next()){
				//ѭ��ȡ��ÿһ�е��е���Ϣ����װ����Ʒ�����������
				Order o=new Order(rs.getInt("oid"),
					rs.getInt("uid"),
					rs.getString("uname"),
					rs.getString("utel"),
					rs.getString("uaddress"),
					rs.getInt("iid"),
					rs.getString("iname"),
					rs.getFloat("iprice"),
					rs.getInt("inumber"),
					rs.getFloat("isum"),
					rs.getString("iphoto"),
					rs.getString("oshopDate"),
					rs.getString("oisSend"),
					rs.getString("osendDate"),
					rs.getString("oisReceive"),
					rs.getString("oreceiveDate"));
				list.add(o);
				
			}
			System.out.println(rs.getInt("uid"));
		}catch (SQLException e) {
			System.out.println("�������ݿ�ʧ��3��");
		}finally {
			//6.�ر����ݿ���Դ
			DBUtil.closeAll(rs, ps, st, conn);
		}
		return list;
	}
	
	public void deleteOrderById(int oid){
		conn= DBUtil.getConn();
		String sql="delete from t_order where oid=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, oid);
			ps.execute();
		} catch (SQLException e) {
			System.out.println("ͨ��idɾ���ö���ʧ�ܣ�");
		} finally {
			DBUtil.closeAll(rs, ps, st, conn);
		}
	}
		
		public Order getOrderById(int oid){
			Order c=null;
			
			try {
				conn= DBUtil.getConn();//��ȡ����
				
				//3��ͨ�����ݿ����Ӷ��󣬴�����������
				st=conn.createStatement();
				
				//4��ʹ�ó�������ִ��sql��䣨��ѯ�������ؽ����
				String sql="select * from t_order where oid="+oid;
				rs=st.executeQuery(sql);
				
				//5�����������е�����
				while(rs!=null&&rs.next()){
					//ѭ��ȡ��һ�е��е���Ϣ����װ����Ʒ�����������
					c=new Order(rs.getInt("oid"),
							rs.getInt("uid"),
							rs.getString("uname"),
							rs.getString("utel"),
							rs.getString("uaddress"),
							rs.getInt("iid"),
							rs.getString("iname"),
							rs.getFloat("iprice"),
							rs.getInt("inumber"),
							rs.getFloat("isum"),
							rs.getString("iphoto"),
							rs.getString("oshopDate"),
							rs.getString("oisSend"),
							rs.getString("osendDate"),
							rs.getString("oisReceive"),
							rs.getString("oreceiveDate"));
				}
				
			} catch (SQLException e) {
				System.out.println("ͨ��ID���Ҷ�������ʧ�ܣ�");
			} finally {
				DBUtil.closeAll(rs, ps, st, conn);
			}
			
			return c;
	}
		
		
		public List<Order> getOByuid(int uid) {
			List<Order> list=new ArrayList<Order>();
			try {
				conn= DataConn.getConn();//��ȡ����
				//3.ͨ�����Ӷ��󣬴�����������
				st=conn.createStatement();
				//4.ʹ�ó�������ִ�в�ѯ��SQL��䣬���ؽ��������
				String sql="select * from t_order where uid="+uid;
				System.out.println("�����ɹ���");
				rs=st.executeQuery(sql);
				//5.ѭ�����������ȡ��������
				while(rs!=null&&rs.next()){
					//ѭ��ȡ��ÿһ�е��е���Ϣ����װ����Ʒ�����������
					Order o=new Order(rs.getInt("oid"),
						rs.getInt("uid"),
						rs.getString("uname"),
						rs.getString("utel"),
						rs.getString("uaddress"),
						rs.getInt("iid"),
						rs.getString("iname"),
						rs.getFloat("iprice"),
						rs.getInt("inumber"),
						rs.getFloat("isum"),
						rs.getString("iphoto"),
						rs.getString("oshopDate"),
						rs.getString("oisSend"),
						rs.getString("osendDate"),
						rs.getString("oisReceive"),
						rs.getString("oreceiveDate"));
					list.add(o);
				}
			}catch (SQLException e) {
				System.out.println("�������ݿ�ʧ�ܣ�");
			}finally {
				//6.�ر����ݿ���Դ
				DataConn.closeAll(rs, ps, st, conn);
			}
			return list;
		}
		
		
		public void updateOrder(Order g){
			conn= DBUtil.getConn();
			String sql="update t_order set uid=?,uname=?,utel=?,uaddress=?"
				     + ",iid=?,iname=?,iprice=?,inumber=?,isum=?,iphoto=?,oshopDate=?,oisSend=? where oid=?";
			try {
				ps=conn.prepareStatement(sql);
				
				ps.setInt(1, g.getUid());
				ps.setString(2, g.getUname());
				ps.setString(3, g.getUtel());
				ps.setString(4, g.getUaddress());
				ps.setInt(5, g.getIid());
				ps.setString(6, g.getIname());
				ps.setFloat(7, g.getIprice());
				ps.setInt(8, g.getInumber());
				ps.setFloat(9, g.getIsum());
				ps.setString(10, g.getIphoto());
				ps.setString(11, g.getOshopDate());
				ps.setString(12, g.getOisSend());
				ps.setInt(13, g.getOid());
				ps.execute();
			} catch (SQLException e) {
				System.out.println("�޸���Ʒʧ�ܣ�");
			} finally {
				DBUtil.closeAll(rs, ps, st, conn);
			}
		}
}
