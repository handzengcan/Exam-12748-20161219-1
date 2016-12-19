package com.maven.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.maven.bean.Film;
import com.maven.services.Services;
import com.maven.servicesImpl.ServicesImpl;

/**
 * Servlet implementation class FilmServlet
 */
public class FilmServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
                 doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String type = request.getParameter("type");
		Services services = new ServicesImpl();
		 List<Film> films = null;
		if (type.equals("show")) {
			
			films = services.selectCusList();
					//ʹ��request�����getSession()��ȡsession�����session�������򴴽�һ��
				// HttpSession session = request.getSession();
			 ////�����ݴ洢��session��
		      request.setAttribute("data", films);
		      request.getRequestDispatcher("/film.jsp").forward(request,response);
		}
		if (type.equals("delete")) {
			String i = request.getParameter("id");
			int id = Integer.parseInt(i);
			
			
		}
		if (type.equals("add")) {
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			String selectLanguage =request.getParameter("selectLanguage");
			int count = Integer.parseInt(selectLanguage);
		boolean istrue = 	services.insertFilm(title, description, count);
		   if (istrue) {
			System.out.println("-----�����ɹ�-----");
			 response.sendRedirect("FilmServlet.action?type=show");
		}	else {
			System.out.println("----����ʧ��----");
		}
		}
		
		if (type.equals("update")) {
			
			
			
		}
	}

}
