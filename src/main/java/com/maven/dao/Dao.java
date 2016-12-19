package com.maven.dao;

import java.util.List;
import java.util.Map;

import com.maven.bean.Customer;
import com.maven.bean.Film;

public interface Dao {
	
	public  boolean selectFist_Name(Customer customer);
	
	public List<Film> selectCusList();
	
	public Map<Integer,String> getLanguagedata();
	
	public boolean insertFilm(String title,String desc,int language_id);

	public Film updateFilm(int id);
}
