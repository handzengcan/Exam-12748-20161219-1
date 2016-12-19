package com.maven.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.catalina.valves.rewrite.Substitution.StaticElement;

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
					//使用request对象的getSession()获取session，如果session不存在则创建一个
				// HttpSession session = request.getSession();
			 ////将数据存储到session中
		      request.setAttribute("data", films);
		      request.getRequestDispatcher("/film.jsp").forward(request,response);
		}
		if (type.equals("delete")) {
			PrintWriter out = response.getWriter();
			out.print("<script>alert(/'外键关联，删除失败！！！/');</script>");
			response.sendRedirect("FilmServlet.action?type=show");
		}
		if (type.equals("add")) {
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			String selectLanguage =request.getParameter("selectLanguage");
			int count = Integer.parseInt(selectLanguage);
		boolean istrue = 	services.insertFilm(title, description, count);
		   if (istrue) {
			System.out.println("-----新增成功-----");
			 response.sendRedirect("FilmServlet.action?type=show");
		}	else {
			System.out.println("----新增失败----");
		}
		}
		
		if (type.equals("update")) {
			Services ser = new ServicesImpl();
			
			Map<Integer, String> map = ser.getLanguagedata();
			request.setAttribute("maps", map);
			
			String count = request.getParameter("uid");
			short id = (short) Integer.parseInt(count);
			Film film = services.updateFilm(id);
			film.setFilmId(id);
			request.setAttribute("filmdata", film);
		    request.getRequestDispatcher("/updateFilm.jsp").forward(request,response);
			
		}
		if (type.equals("updateNew")) {
			String map = request.getParameter("selectLanguageNew");
			int n = Integer.parseInt(map);
			String t = request.getParameter("title1");
			String d = request.getParameter("description1");
			String s =request.getParameter("language1");
			String i = request.getParameter("id");
			int idd = Integer.parseInt(i);
			System.out.println(idd+"----");
			Boolean is = services.updateFileNew(t, d, n, idd);
			if (is) {
				response.sendRedirect("FilmServlet.action?type=show");
				System.out.println("success----");
			}else{
				System.out.println("更新失败");
			}
		}
	}

}
