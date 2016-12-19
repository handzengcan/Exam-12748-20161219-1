package com.maven.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.maven.bean.Customer;
import com.maven.bean.Film;
import com.maven.bean.Language;
import com.maven.dao.Dao;
import com.maven.db.DBConnection;

public class DaoImpl implements Dao{
	private  Connection conn;
	private  PreparedStatement preparedStatement;

	//验证用户登录
	public  boolean selectFist_Name(Customer customer) {
		// TODO Auto-generated method stub
		boolean result = false;
		String sql = "select * from sakila.customer where first_name=?";
		conn = DBConnection.getDBConnection();
	//	preparedStatement = DBConnection.getPreparedStatement(Sql.select_last_neme);
		try {
			preparedStatement = DBConnection.getPreparedStatement(sql);
			preparedStatement.setString(1, customer.getFirst_name());
		    ResultSet resultSet = preparedStatement.executeQuery();
		    if (resultSet.next()) {
			result = true;
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally {
			DBConnection.close();
		}*/
		
		return result;
	}

	public List<Film> selectCusList() {
		// TODO Auto-generated method stub
		List<Film> listFilms = new ArrayList<Film>();
		String sql = "select film_id,title,description,name from sakila.film,sakila.language where film.language_id = language.language_id ";
		conn = DBConnection.getDBConnection();
		Film film = null;
		Language language = null;
	//	preparedStatement = DBConnection.getPreparedStatement(Sql.select_last_neme);
		try {
			preparedStatement = DBConnection.getPreparedStatement(sql);
		    ResultSet resultSet = preparedStatement.executeQuery();
		    while (resultSet.next()) {
		    	film = new Film();
		    	language = new Language();
		    	language.setName(resultSet.getString("name"));
		    	film.setFilmId(resultSet.getShort("film_id"));
		    	film.setTitle(resultSet.getString("title"));
		    	film.setDescription(resultSet.getString("description"));
		    	film.setLanguage(language);
		    	listFilms.add(film);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally {
			DBConnection.close();
		}*/
		
		return listFilms;
	}

	public Map<Integer, String> getLanguagedata() {
		// TODO Auto-generated method stub
		Map<Integer, String> map = new HashMap<Integer, String>();
		String sql = "select * from sakila.`language`";
		conn = DBConnection.getDBConnection();
	//	preparedStatement = DBConnection.getPreparedStatement(Sql.select_last_neme);
		try {
			preparedStatement = DBConnection.getPreparedStatement(sql);
		    ResultSet resultSet = preparedStatement.executeQuery();
		    while (resultSet.next()) {
			  map.put(resultSet.getInt("language_id"),resultSet.getString("name"));
		   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally {
			DBConnection.close();
		}*/
		return map;
		
	}

	public boolean insertFilm(String title, String desc, int language_id) {
		// TODO Auto-generated method stub
		boolean result = false;
		String sql = "insert into sakila.film(title,description,language_id) values(?,?,?)";
		conn = DBConnection.getDBConnection();
	//	preparedStatement = DBConnection.getPreparedStatement(Sql.select_last_neme);
		try {
			preparedStatement = DBConnection.getPreparedStatement(sql);
			preparedStatement.setString(1, title);
			preparedStatement.setString(2,desc);
			preparedStatement.setInt(3, language_id);
		    int count = preparedStatement.executeUpdate();
		    if (count!=0) {
		    	result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally {
			DBConnection.close();
		}*/
		return result;
	}

	public Film updateFilm(int id) {
		// TODO Auto-generated method stub
		Film film = null;
		String sql = "select film_id,title,description, name from sakila.film,sakila.language where film.language_id = language.language_id  AND film_id = ?";
		conn = DBConnection.getDBConnection();
	//	preparedStatement = DBConnection.getPreparedStatement(Sql.select_last_neme);
		try {
			film = new Film();
			preparedStatement = DBConnection.getPreparedStatement(sql);
			preparedStatement.setInt(1, id);
		    ResultSet result = preparedStatement.executeQuery();
		    while (result.next()) {
		    	film.setTitle(result.getString("title"));
                film.setFilmId(result.getShort("film_id"));
				film.setDescription(result.getString("description"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/*finally {
			DBConnection.close();
		}*/
		return film;
		
		
	}
	
	//查询所有的film
	
	/* public static void main(String[] args) {
      String username="ABNEY";
		Customer user  = new Customer(); 
         user.setLast_name(username);
         
         DaoImpl daoImpl = new DaoImpl();
      boolean is =    daoImpl.selectFist_Name(user);
         System.out.println(is);
	} */

}
