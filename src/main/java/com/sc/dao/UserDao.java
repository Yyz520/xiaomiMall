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
	//�������ݿ���ʵĶ���
		Connection conn=null;
		Statement st=null;
		PreparedStatement ps=null;
		ResultSet rs=null;

	//ͨ���û�����ѯ�û���Ϣ
		public User getUserByname(String uname){
			User u=null;
			try {
				conn= DBUtil.getConn();//��ȡ����
				//3.ͨ�����Ӷ��󣬴�����������
				st=conn.createStatement();
				//4.ʹ�ó�������ִ�в�ѯ��SQL��䣬���ؽ��������
				String sql="select * from t_user where uname='"+uname+"'";
				System.out.println("�����ɹ���");
				rs=st.executeQuery(sql);
				//5.ѭ�����������ȡ��������
				while(rs!=null&&rs.next()){
					//ѭ��ȡ��ÿһ�е��е���Ϣ����װ���û������������
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
				System.out.println("�������ݿ�ʧ�ܣ�");
			}finally {
				//6.�ر����ݿ���Դ
				DBUtil.closeAll(rs, ps, st, conn);
			}
			return u;
		}
		
		//ͨ���û�����ѯ�û�id
		public int getUserid(String uname){
			int uid=0;
			try {
				conn= DBUtil.getConn();//��ȡ����
				//3.ͨ�����Ӷ��󣬴�����������
				st=conn.createStatement();
				//4.ʹ�ó�������ִ�в�ѯ��SQL��䣬���ؽ��������
				String sql="select uid from t_user where uname='"+uname+"'";
				System.out.println("�����ɹ���");
				rs=st.executeQuery(sql);
				uid=rs.getInt(uid);
			}catch (SQLException e) {
				System.out.println("�������ݿ�ʧ�ܣ�");
			}finally {
				//6.�ر����ݿ���Դ
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
				System.out.println("��ѯ�û�ʧ��");
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
				System.out.println("ͨ��idɾ�����û�ʧ�ܣ�");
			} finally {
				DBUtil.closeAll(rs, ps, st, conn);
			}
		}
		//ע����֤�û����Ƿ��ظ�
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
				
			
				//ͨ���û����г�������Ϣ
					public User getGoodsById(int gid){
						User g=null;
						
						try {
							conn= DataConn.getConn();//��ȡ����
							
							//3��ͨ�����ݿ����Ӷ��󣬴�����������
							st=conn.createStatement();
							
							//4��ʹ�ó�������ִ��sql��䣨��ѯ�������ؽ����
							String sql="select * from goods where gid="+gid;
							rs=st.executeQuery(sql);
							
							//5�����������е�����
							while(rs!=null&&rs.next()){
								//ѭ��ȡ��һ�е��е���Ϣ����װ����Ʒ�����������
								g=new User(rs.getInt(gid), rs.getString("uname"), rs.getString("utureName"), rs.getString("upassword"), rs.getString("uidentity"), rs.getString("uemail"), rs.getString("uaddress"), rs.getString("uquestion"), rs.getString("uanswer"), rs.getString("uzipCode"), rs.getString("utel"), rs.getString("uvip"), rs.getString("uregTime"));
							}
							
						} catch (SQLException e) {
							System.out.println("ͨ����Ʒ��Ż�ȡ��Ʒ����ʧ�ܣ�");
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
						System.out.println("ͨ����Ʒ��Ż�ȡ��Ʒʧ��");
					}finally {
						DataConn.closeAll(rs, ps, st, conn);
					}		
					return null;
				}
						
				//��ѯ�û���Ϣ
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
						System.out.println("�޸��û���Ϣʧ��");
					}finally {
						DataConn.closeAll(rs, ps, st, conn);
					}
					return u;
					
				}
				
				
				//�޸ĸ�����Ϣ
				
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
							System.out.println("�޸���Ʒʧ�ܣ�");
						} finally {
							DataConn.closeAll(rs, ps, st, conn);
						}
					}

}
