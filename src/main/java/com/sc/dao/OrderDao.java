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
		    System.out.println("要执行的sql语句是"+sql);
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
				System.out.println("连接数据库失败2！");
			} finally {
				//6.关闭数据库资源
				DBUtil.closeAll(rs, ps, st, conn);
			}		
	}
	
	public List<Order> getOrder() {
		List<Order> list=new ArrayList<Order>();
		try {
			conn= DBUtil.getConn();//获取连接
			//3.通过连接对象，创建陈述对象
			st=conn.createStatement();
			//4.使用陈述对象，执行查询的SQL语句，返回结果集对象
			String sql="select * from t_order";
			System.out.println("操作成功！");
			rs=st.executeQuery(sql);
			//5.循环结果集，获取所有数据
			while(rs!=null&&rs.next()){
				//循环取出每一行的列的信息，封装到商品对象的属性中
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
			System.out.println("连接数据库失败3！");
		}finally {
			//6.关闭数据库资源
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
			System.out.println("通过id删除该订单失败！");
		} finally {
			DBUtil.closeAll(rs, ps, st, conn);
		}
	}
		
		public Order getOrderById(int oid){
			Order c=null;
			
			try {
				conn= DBUtil.getConn();//获取连接
				
				//3、通过数据库连接对象，创建陈述对象
				st=conn.createStatement();
				
				//4、使用陈述对象，执行sql语句（查询），返回结果集
				String sql="select * from t_order where oid="+oid;
				rs=st.executeQuery(sql);
				
				//5、处理结果集中的数据
				while(rs!=null&&rs.next()){
					//循环取出一行的列的信息，封装到商品对象的属性中
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
				System.out.println("通过ID查找订单对象失败！");
			} finally {
				DBUtil.closeAll(rs, ps, st, conn);
			}
			
			return c;
	}
		
		
		public List<Order> getOByuid(int uid) {
			List<Order> list=new ArrayList<Order>();
			try {
				conn= DataConn.getConn();//获取连接
				//3.通过连接对象，创建陈述对象
				st=conn.createStatement();
				//4.使用陈述对象，执行查询的SQL语句，返回结果集对象
				String sql="select * from t_order where uid="+uid;
				System.out.println("操作成功！");
				rs=st.executeQuery(sql);
				//5.循环结果集，获取所有数据
				while(rs!=null&&rs.next()){
					//循环取出每一行的列的信息，封装到商品对象的属性中
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
				System.out.println("连接数据库失败！");
			}finally {
				//6.关闭数据库资源
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
				System.out.println("修改商品失败！");
			} finally {
				DBUtil.closeAll(rs, ps, st, conn);
			}
		}
}
