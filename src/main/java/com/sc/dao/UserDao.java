package com.sc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sc.bean.Order;
import com.sc.bean.User;


public class UserDao {
	//定义数据库访问的对象
		Connection conn=null;
		Statement st=null;
		PreparedStatement ps=null;
		ResultSet rs=null;

	//通过用户名查询用户信息
		public User getUserByname(String uname){
			User u=null;
			try {
				conn= DBUtil.getConn();//获取连接
				//3.通过连接对象，创建陈述对象
				st=conn.createStatement();
				//4.使用陈述对象，执行查询的SQL语句，返回结果集对象
				String sql="select * from t_user where uname='"+uname+"'";
				System.out.println("操作成功！");
				rs=st.executeQuery(sql);
				//5.循环结果集，获取所有数据
				while(rs!=null&&rs.next()){
					//循环取出每一行的列的信息，封装到用户对象的属性中
					u=new User(rs.getInt("uid"),
							rs.getString("uname"),
							rs.getString("utureName"),
							rs.getString("upassword"),
							rs.getString("uidentity"),
							rs.getString("uemail"),
							rs.getString("uaddress"),
							rs.getString("uquestion"),
							rs.getString("uanswer"),
							rs.getString("uzipCode"),
							rs.getString("utel"),
							rs.getString("uvip"),
							rs.getString("uregTime"));
				}
			}catch (SQLException e) {
				System.out.println("连接数据库失败！");
			}finally {
				//6.关闭数据库资源
				DBUtil.closeAll(rs, ps, st, conn);
			}
			return u;
		}
		
		//通过用户名查询用户id
		public int getUserid(String uname){
			int uid=0;
			try {
				conn= DBUtil.getConn();//获取连接
				//3.通过连接对象，创建陈述对象
				st=conn.createStatement();
				//4.使用陈述对象，执行查询的SQL语句，返回结果集对象
				String sql="select uid from t_user where uname='"+uname+"'";
				System.out.println("操作成功！");
				rs=st.executeQuery(sql);
				uid=rs.getInt(uid);
			}catch (SQLException e) {
				System.out.println("连接数据库失败！");
			}finally {
				//6.关闭数据库资源
				DBUtil.closeAll(rs, ps, st, conn);
			}
			return uid;
		}

		
		public List selectUsers(){
			List list=new ArrayList();
			try {
				conn= DBUtil.getConn();
				st=conn.createStatement();
				String sql="select * from t_user";
				rs=st.executeQuery(sql);
				while(rs!=null&&rs.next()){
					User g = new User(rs.getInt("uid"),
							rs.getString("uname"),
							rs.getString("utureName"),
							rs.getString("upassword"),
							rs.getString("uidentity"),
							rs.getString("uemail"),
							rs.getString("uaddress"),
							rs.getString("uquestion"),
							rs.getString("uanswer"),
							rs.getString("uzipCode"),
							rs.getString("utel"),
							rs.getString("uvip"),
							rs.getString("uregTime"));
			      list.add(g);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("查询用户失败");
			} finally{
				DBUtil.closeAll(rs, ps, st, conn);
			}
			return list;
		}
		
		public void deleteUserById(int uid){
			conn= DBUtil.getConn();
			String sql="delete from t_user where uid=?";
			try {
				ps=conn.prepareStatement(sql);
				ps.setInt(1, uid);
				ps.execute();
			} catch (SQLException e) {
				System.out.println("通过id删除该用户失败！");
			} finally {
				DBUtil.closeAll(rs, ps, st, conn);
			}
		}
		//注册验证用户名是否重复
				public Boolean ndql(String uname){
					Boolean b=false;
					try {
						
						conn= DataConn.getConn();
						st=conn.createStatement();
						String sql="select * from t_user where uname='"+uname+"'";
						
						rs=st.executeQuery(sql);
						if(rs!=null&&rs.next()){
							b=true;
							
						}
						
					} catch (SQLException e) {
						System.out.println("1");
					}finally {
						DataConn.closeAll(rs, ps, st, conn);
					}		
					return b;
				}
				
			
				//通过用户名列出个人信息
					public User getGoodsById(int gid){
						User g=null;
						
						try {
							conn= DataConn.getConn();//获取连接
							
							//3、通过数据库连接对象，创建陈述对象
							st=conn.createStatement();
							
							//4、使用陈述对象，执行sql语句（查询），返回结果集
							String sql="select * from goods where gid="+gid;
							rs=st.executeQuery(sql);
							
							//5、处理结果集中的数据
							while(rs!=null&&rs.next()){
								//循环取出一行的列的信息，封装到商品对象的属性中
								g=new User(rs.getInt(gid), rs.getString("uname"), rs.getString("utureName"), rs.getString("upassword"), rs.getString("uidentity"), rs.getString("uemail"), rs.getString("uaddress"), rs.getString("uquestion"), rs.getString("uanswer"), rs.getString("uzipCode"), rs.getString("utel"), rs.getString("uvip"), rs.getString("uregTime"));
							}
							
						} catch (SQLException e) {
							System.out.println("通过商品编号获取商品对象失败！");
						} finally {
							DataConn.closeAll(rs, ps, st, conn);
						}
						
						return g;
					}
					
				public User getUserById(int uid){
					User u=null;
				
					
					try {
						
						conn= DataConn.getConn();
						st=conn.createStatement();
						String sql="select * from User where uid="+uid;
						
						rs=st.executeQuery(sql);
						while(rs!=null&&rs.next()){
							u=new User(rs.getInt("uid"), rs.getString("uname"), rs.getString("utureName"), rs.getString("upassword"), rs.getString("uidentity"), rs.getString("uemail"), rs.getString("uaddress"), rs.getString("uquestion"), rs.getString("uanswer"), rs.getString("uzipCode"), rs.getString("utel"), rs.getString("uvip"), rs.getString("uregTime"));
							
						}
						
					} catch (SQLException e) {
						System.out.println("通过商品编号获取商品失败");
					}finally {
						DataConn.closeAll(rs, ps, st, conn);
					}		
					return null;
				}
						
				//查询用户信息
				public User updateUser(User u){
					conn= DataConn.getConn();
					
					String sql="update t_user set uname=?,utel=?,upassword=?,uidentity=?,uemail=?,uaddress=?";
					try {
						ps=conn.prepareStatement(sql);
						ps.setString(1, u.getuname());
						ps.setString(2, u.getutel());
						ps.setString(3, u.getupassword());
						ps.setString(4,u.getuidentity());
						ps.setString(5,u.getuemail());
						ps.setString(6,u.getuaddress());
						ps.execute();
						
					} catch (SQLException e) {
						System.out.println("修改用户信息失败");
					}finally {
						DataConn.closeAll(rs, ps, st, conn);
					}
					return u;
					
				}
				
				
				//修改个人信息
				
					public void updateUser1(User u){
						conn= DataConn.getConn();
						String sql="update t_user set uname=?,utel=?,upassword=?"
								+ ",uemail=?,utureName=?,uaddress=? where uid=?";
						try {
							ps=conn.prepareStatement(sql);
							ps.setString(1, u.getuname());
							ps.setString(2, u.getutel());
							ps.setString(3, u.getupassword());
							/*ps.setString(3, u.getutel());*/
							ps.setString(4, u.getuemail());
							ps.setString(5, u.getutureName());
							ps.setString(6, u.getuaddress());
							ps.setInt(7, u.getuid());
							ps.execute();
						} catch (SQLException e) {
							System.out.println("修改商品失败！");
						} finally {
							DataConn.closeAll(rs, ps, st, conn);
						}
					}

}
