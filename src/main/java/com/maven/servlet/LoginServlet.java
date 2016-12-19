package com.maven.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maven.bean.Customer;
import com.maven.services.Services;
import com.maven.servicesImpl.ServicesImpl;

public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String type=req.getParameter("type");
		if(type.equals("login")){//登录  
            String username = req.getParameter("username");  
            String password = req.getParameter("password");  
            if(username==null||"".equals(username.trim())||password==null||"".equals(password.trim())){  
                 System.out.println("用户名或密码不能为空！");  
                 resp.sendRedirect("index.jsp");  
                 return;  
             }  
             Customer user  = new Customer(); 
             user.setFirst_name(username);
             Services services = new ServicesImpl();
              boolean istrue = services.selectFist_Name(user);  
              if(istrue){  
                  System.out.println("登录成功！");  
                //  req.getSession().setAttribute("username", username);  
                  resp.sendRedirect("FilmServlet.action?type=show");  
                  return; 
              }else{  
                  System.out.println("用户名错误，登录失败！");  
                  resp.sendRedirect("index.jsp");  
                  return;  
              }  
        }
		
		
		
	}
	
	

}
