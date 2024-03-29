package com.sc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/checkCode")
public class CheckCode extends HttpServlet {
    //private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code = request.getParameter("code");
        // 验证验证码
        String sessionCode = request.getSession().getAttribute("code").toString();
        if (code != null && !"".equals(code) && sessionCode != null && !"".equals(sessionCode)) {
            if (code.equalsIgnoreCase(sessionCode)) {
               // response.getWriter().println("验证通过！");
               // req.getRequestDispatcher("mphone.jsp").forward(req, resp);
                request.getRequestDispatcher("main.jsp").forward(request, response);
            } else {
                //response.getWriter().println("验证失败！");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else {
            //response.getWriter().println("验证失败！");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

}