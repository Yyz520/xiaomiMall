package com.sc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sc.bean.Order;
import com.sc.bean.Page;
import com.sc.bean.Item;
import com.sc.bean.Order;


public class CarsDao {
	Connection conn=null;
	Statement st=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public List selectCars(){
		List list=new ArrayList();

				try {
					conn= DBUtil.getConn();
					st=conn.createStatement();
					String sql="select * from t_order";
					rs=st.executeQuery(sql);
					while(rs!=null&&rs.next()){
		              
						Order c=new Order(rs.getInt("oid"),
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
								          
						list.add(c);
					}
				
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("");
				} finally {
					DBUtil.closeAll(rs, ps, st, conn);
				}
				
				return list;
			}
	
	public Order selectOrdersById(int oid){
		Order c=null;
	
		try {
			conn= DBUtil.getConn();
			st=conn.createStatement();
			String sql="select * from t_order where oid="+oid;
			rs=st.executeQuery(sql);
			while(rs!=null&&rs.next()){
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
			
		}  catch (SQLException e) {
			e.printStackTrace();
			System.out.println("");
		}  finally {
			DBUtil.closeAll(rs, ps, st, conn);
		}
		
		return c;
	}
	
	 public void updateOrders(Order c){
	
			try {
				conn= DBUtil.getConn();
				String sql="update t_order set uid=?,uname=?"
		+ ",utel=?,uaddress=?,itemId=?,itemName=?,itemPrice=?,itemNum=?,itemSum=?,itemPhoto=?,oshopDate=?,oisSend=?,osendDate=?,oisReceive=?,oreceiveDate=? where oid=?";
				ps=conn.prepareStatement(sql);
				ps.setInt(1,c.getUid() );
				ps.setString(2, c.getUname());
				ps.setString(3,c.getUtel());
				ps.setString(4, c.getUaddress());
				ps.setInt(5, c.getIid());
				ps.setString(6, c.getIname());
				ps.setDouble(7, c.getIprice());
				ps.setInt(8, c.getInumber());
				ps.setDouble(9, c.getIsum());
				ps.setString(10, c.getIphoto());
				ps.setString(11, c.getOshopDate());
				ps.setString(12, c.getOisSend());
				ps.setString(13, c.getOsendDate());
				ps.setString(14, c.getOisReceive());
				ps.setString(15, c.getOreceiveDate());
				ps.setInt(16, c.getOid());
				
				ps.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("");
			}  finally {
				DBUtil.closeAll(rs, ps, st, conn);
			}
			
		}
	 
	
	 public void deleteOrderById(int oid){
			
			try {
				conn= DBUtil.getConn();
				st=conn.createStatement();
				String sql="delete from t_order where oid="+oid;
				
		        st.executeUpdate(sql);
				
			}catch (SQLException e) {
				e.printStackTrace();
				System.out.println("");
			}  finally {
				DBUtil.closeAll(rs, ps, st, conn);
			}
			
		}

	 public List selectGOrderPage(Page p, String carname){
			List list=new ArrayList();
			
			try {
				conn= DBUtil.getConn();
	            String sql="select * from t_order where 1 = 1";
				
				if(carname != null && !"".equals(carname)){
					sql =  sql + " and (uname like '%"+carname+"%'  or itemName like '%"+carname+"%') ";
				}
				sql+=" limit ?,?";
				ps=conn.prepareStatement(sql);
				ps.setInt(1, (p.getPageNum()-1)*p.getPageSize());
				ps.setInt(2, p.getPageSize());
				
				rs=ps.executeQuery();
				
				while(rs!=null&&rs.next()){
					Order c=new Order(rs.getInt("oid"),
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
				          
		           list.add(c);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("");
			}  finally {
				DBUtil.closeAll(rs, ps, st, conn);
			}
			
			return list;
		}
	
	 public List selectCarsPage(Page p){
			List list=new ArrayList();
			
			try {
				conn= DBUtil.getConn();
				String sql="select * from t_order limit ?,?";
				ps=conn.prepareStatement(sql);
				ps.setInt(1, (p.getPageNum()-1)*p.getPageSize());
				ps.setInt(2, p.getPageSize());
				
				rs=ps.executeQuery();
				
				while(rs!=null&&rs.next()){
	               
					Order c=new Order(rs.getInt("oid"),
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
					list.add(c);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("");
			}  finally {
				DBUtil.closeAll(rs, ps, st, conn);
			}
			
			return list;
		}

	 public int selectCarsPageCount(){
			int count=0;

			try {
				conn= DBUtil.getConn();
				String sql="select count(*) from t_order";
				ps=conn.prepareStatement(sql);
				
				rs=ps.executeQuery();
				
				while(rs!=null&&rs.next()){
	               count=rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("");
			} finally {
				DBUtil.closeAll(rs, ps, st, conn);
			}
			
			return count;
		}
	 
	 public void ChaKan(int oid){
		 
		 try {
			    conn = DBUtil.getConn();
			
			    Statement st=conn.createStatement();
			
			    String sql="update t_order set oisSend='1',oSendDate=? where oid=?";
			    ps=conn.prepareStatement(sql);
			    ps.setString(1, new Date().toLocaleString());
			    ps.setInt(2, oid);

			    ps.executeUpdate();
			    
}catch (SQLException e) {
	e.printStackTrace();
	System.out.println("");
}		
finally{
	DBUtil.closeAll(rs, ps, st, conn);
}		 
	
	 }
	
		 public void ChaKan1(int oid){
			 
			 try {
				    conn = DBUtil.getConn();
				    
				    Statement st=conn.createStatement();
				 
				    String sql="update t_order set oisReceive='1',oReceiveDate=? where oid=?";
				    ps=conn.prepareStatement(sql);
				    ps.setString(1, new Date().toLocaleString());
				    ps.setInt(2, oid);

				    ps.executeUpdate();
				    
	}catch (SQLException e) {
		e.printStackTrace();
		System.out.println("");
	}		
	finally{
		DBUtil.closeAll(rs, ps, st, conn);
	}			    	
	 
		 }

		  public Order deletesdingdanById(int oid){

				try {
					conn= DBUtil.getConn();
					st=conn.createStatement();
					String sql="delete from t_order where oid="+oid;
					
			        st.executeUpdate(sql);
					
				}catch (SQLException e) {
					e.printStackTrace();
					System.out.println("");
				}  finally {
					DBUtil.closeAll(rs, ps, st, conn);
				}
				return null;
			}
}