package com.sc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import com.sc.bean.Admin;


public class AdminDao {

	Connection conn=null;
	Statement st=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public Admin Login(String aname,String apassword){
		Admin u=null;		
		try {
			conn= DBUtil.getConn();
			st=conn.createStatement();
			String sql="select * from t_admin where aname=? and apassword=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, aname);
			ps.setString(2, apassword);			
			rs=ps.executeQuery();		
			if(rs!=null&&rs.next()){
				u=new Admin(rs.getInt("aid"), 
						    rs.getString("aname"), 
						    rs.getString("apassword"));
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("登陆失败");
		} 	
		return u;
	}
	
	public List selectAdmin(){
		List list=new ArrayList();
		
		try {
			conn= DBUtil.getConn();
			st=conn.createStatement();
			String sql="select * from t_admin";
			rs=st.executeQuery(sql);
			while(rs!=null&&rs.next()){
				Admin g = new Admin(rs.getInt("aid"),
						                 rs.getString("aname"), 
						                 rs.getString("apassword"));
		      list.add(g);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("查询失败");
		} finally{
			DBUtil.closeAll(rs, ps, st, conn);
		}
		return list;
	}
		
		public void deleteAdminById(int aid){
			conn= DBUtil.getConn();
			String sql="delete from t_admin where aid=?";
			try {
				ps=conn.prepareStatement(sql);
				ps.setInt(1, aid);
				ps.execute();
			} catch (SQLException e) {
				System.out.println("通过id删除该商品失败！");
			} finally {
				DBUtil.closeAll(rs, ps, st, conn);
			}
			
	}
		public Admin getAdminById(int aid){
			Admin c=null;
			
			try {
				conn= DBUtil.getConn();//获取连接
				
				//3、通过数据库连接对象，创建陈述对象
				st=conn.createStatement();
				
				//4、使用陈述对象，执行sql语句（查询），返回结果集
				String sql="select * from t_admin where aid="+aid;
				rs=st.executeQuery(sql);
				
				//5、处理结果集中的数据
				while(rs!=null&&rs.next()){
					//循环取出一行的列的信息，封装到商品对象的属性中
					c=new Admin(rs.getInt("aid"), 
							rs.getString("aname"), 
							rs.getString("apassword"));
				}
				
			} catch (SQLException e) {
				System.out.println("通过商品编号获取商品对象失败！");
			} finally {
				DBUtil.closeAll(rs, ps, st, conn);
			}
			
			return c;
		}
			public void updateAdmin(Admin g){
				conn= DBUtil.getConn();
				String sql="update t_admin set aname=?,apassword=?";
				try {
					ps=conn.prepareStatement(sql);
					ps.setString(1, g.getAname());
					ps.setString(2, g.getApassword());
					
					ps.execute();
				} catch (SQLException e) {
					System.out.println("修改管理员失败！");
				} finally {
					DBUtil.closeAll(rs, ps, st, conn);
				}		
		}
}
