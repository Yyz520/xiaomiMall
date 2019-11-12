package com.sc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sc.bean.User;
import com.sc.dao.UserDao;

@WebServlet("/UserUptate")
public class UserUptate extends HttpServlet {
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String suid=req.getParameter("uid");
		String uname= req.getParameter("uname");
		String upassword=req.getParameter("upassword");
		String utel= req.getParameter("utel");
		
		String uemail= req.getParameter("uemail");
		String utureName=req.getParameter("utureName");
		String uaddress=req.getParameter("uaddress");		
		int uid=Integer.parseInt(suid);
		
		User u=new User(uid, uname, utureName, upassword, "uidentity", uemail, uaddress, "uquestion", "uanswer", "uzipCode", utel, "uvip", "uregTime");
		
		UserDao dao=new UserDao();
		
		dao.updateUser1(u);
	
		
		HttpSession session=req.getSession();
		session.setAttribute("self", u);
		
		req.setAttribute("u",u );
		
		
		req.getRequestDispatcher("self_info.jsp").forward(req, resp);
	}

}
