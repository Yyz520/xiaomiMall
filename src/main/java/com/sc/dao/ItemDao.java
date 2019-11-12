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
	//定义数据库访问的对象
	Connection conn=null;
	Statement st=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	//查询所有商品列表
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
			System.out.println("连接数据库失败！");
		}finally{
			DataConn.closeAll(rs, ps, st, conn);
		}
		return list;
	}
	
	//通过商品种类编号查询商品
	public List<Item> getGoodsBycid(int cid){
		List<Item> list=new ArrayList<Item>();
		try {
			conn= DataConn.getConn();//获取连接
			st=conn.createStatement();
			String sql="select * from t_item where cid="+cid;
			System.out.println("操作成功！");
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
			System.out.println("连接数据库失败！");
		}finally {
			//6.关闭数据库资源
			DataConn.closeAll(rs, ps, st, conn);
		}
		return list;
	}
	
	//通过商品编号查询商品
	public Item getItemById(int itemId){
		Item i=null;
		try {
			conn= DataConn.getConn();//获取连接
			//3.通过连接对象，创建陈述对象
			st=conn.createStatement();
			//4.使用陈述对象，执行查询的SQL语句，返回结果集对象
			String sql="select * from t_item where itemId="+itemId;
			System.out.println("操作成功！");
			rs=st.executeQuery(sql);
			//5.循环结果集，获取所有数据
			while(rs!=null&&rs.next()){
				//循环取出每一行的列的信息，封装到商品对象的属性中
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
			System.out.println("连接数据库失败！");
		}finally {
			//6.关闭数据库资源
			DataConn.closeAll(rs, ps, st, conn);
		}
		return i;
	}
	
		//修改商品库存
		public void updateitem(int id,int shuliang){				
		try {
			conn= DataConn.getConn();//获取连接
		    String sql="update t_item set itemNum=itemNum-? where itemId=?";
		    System.out.println("操作成功！");
		    ps=conn.prepareStatement(sql);
		    ps.setInt(1,shuliang);
		    ps.setInt(2,id);
		    ps.executeUpdate();
		 }catch (SQLException e) {
			System.out.println("连接数据库失败！");
		}finally {
			//6.关闭数据库资源
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
			    System.out.println("操作成功2！");
			    ps.setString(1, "%"+s+"%");
			    ps.setString(2, "%"+s+"%");
			    ps.setString(3, "%"+s+"%");
			    rs=ps.executeQuery();			    
			    while(rs!=null&&rs.next()){
			    	//从数据库取出每条商品信息，封装成商品对象
			    	//这个地方是数据库的列名
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
			    	list.add(i);//存入集合
			    }}catch (SQLException e) {
					System.out.println("连接数据库失败！");
				}finally {
					//6.关闭数据库资源
					DataConn.closeAll(rs, ps, st, conn);
				}			
			return list;
		}
}
