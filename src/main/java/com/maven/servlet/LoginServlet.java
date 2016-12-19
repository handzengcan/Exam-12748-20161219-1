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
		if(type.equals("login")){//��¼  
            String username = req.getParameter("username");  
            String password = req.getParameter("password");  
            if(username==null||"".equals(username.trim())||password==null||"".equals(password.trim())){  
                 System.out.println("�û��������벻��Ϊ�գ�");  
                 resp.sendRedirect("index.jsp");  
                 return;  
             }  
             Customer user  = new Customer(); 
             user.setFirst_name(username);
             Services services = new ServicesImpl();
              boolean istrue = services.selectFist_Name(user);  
              if(istrue){  
                  System.out.println("��¼�ɹ���");  
                //  req.getSession().setAttribute("username", username);  
                  resp.sendRedirect("FilmServlet.action?type=show");  
                  return; 
              }else{  
                  System.out.println("�û������󣬵�¼ʧ�ܣ�");  
                  resp.sendRedirect("index.jsp");  
                  return;  
              }  
        }
		
		
		
	}
	
	

}
