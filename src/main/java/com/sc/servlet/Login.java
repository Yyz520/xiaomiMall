package com.sc.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sc.bean.User;
import com.sc.dao.DataConn;
import com.sc.dao.UserDao;


@WebServlet("/Login")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uname=req.getParameter("uname");
		String upassword=req.getParameter("upassword");
		String  utel=req.getParameter("utel");
		String  uemail=req.getParameter("uemail");
		String utureName=req.getParameter("utureName");
		String uaddress=req.getParameter("uaddress");
		User u=null;
		
		
		/*UserDao dao=new UserDao();
		Boolean l=dao.ndqq(upassword);
		if(l==false){			
			//req.setAttribute("utureName", utureName);
			req.setAttribute("uname", uname);
			req.getRequestDispatcher("login.jsp?chaa==yes").forward(req, resp);
			
			return;
		}*/
		
		
		 String code = req.getParameter("code");
	        // 验证验证码
	        String sessionCode = req.getSession().getAttribute("code").toString();
	        if (code != null && !"".equals(code) && sessionCode != null && !"".equals(sessionCode)) {
	            if (code.equalsIgnoreCase(sessionCode)) {
	               
	            } else {
	                req.getRequestDispatcher("login.jsp?code=error").forward(req, resp);
	                return;
	            }
	        } else {
	            //resp.getWriter().println("验证失败！");
	            req.getRequestDispatcher("login.jsp?code=error").forward(req, resp);
	            return;
	        }
		
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		boolean  isSuccess=false;	
		try {
			conn= DataConn.getConn();
			st=conn.createStatement();			
			String sql="select * from t_user where uname='"+uname+"' and upassword='"+upassword+"'";
			System.out.println("要执行的sql语句是"+sql);
			rs=st.executeQuery(sql);
			while(rs!=null&&rs.next()){
				isSuccess=true;
				 u = new User(rs.getInt("uid"), rs.getString("uname"), rs.getString("utureName"), rs.getString("upassword"), rs.getString("uidentity"), rs.getString("uemail"), rs.getString("uaddress"), rs.getString("uquestion"), rs.getString("uanswer"), rs.getString("uzipCode"), rs.getString("utel"), rs.getString("uvip"), rs.getString("uregTime"));
			}
		} catch (SQLException e) {
			System.out.println("连接数据库失败");
		}finally {
			try {
				if(st!=null)st.close();
				if(st!=null)st.close();
				if(conn!=null)conn.close();
			} catch (SQLException e2) {
				System.out.println("资源关闭失败");
			}
		}
		if(isSuccess){			
			HttpSession session=req.getSession();
			session.setAttribute("uname", uname);
			/*session.setAttribute("upassword", upassword);
			session.setAttribute("utel", utel);
			session.setAttribute("uemail", uemail);
			session.setAttribute("utureName", utureName);
			session.setAttribute("uaddress", uaddress);*/
			session.setAttribute("self", u);
			
			req.getRequestDispatcher("main.jsp").forward(req, resp);
		}else{
			req.getRequestDispatcher("login.jsp?coda==erro").forward(req, resp);
		}	
		
	}
	
	
	
}
