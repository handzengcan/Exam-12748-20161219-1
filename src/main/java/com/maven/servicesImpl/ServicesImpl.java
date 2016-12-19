package com.maven.servicesImpl;

import java.util.List;
import java.util.Map;

import com.maven.bean.Customer;
import com.maven.bean.Film;
import com.maven.dao.Dao;
import com.maven.daoImpl.DaoImpl;
import com.maven.services.Services;

public class ServicesImpl implements Services{
     
	private Dao  dao  = new DaoImpl();
	public boolean selectFist_Name(Customer customer) {
		// TODO Auto-generated method stub
		return dao.selectFist_Name(customer);
	}
	public List<Film> selectCusList() {
		// TODO Auto-generated method stub
		return dao.selectCusList();
	}
	public Map<Integer, String> getLanguagedata() {
		// TODO Auto-generated method stub
		return dao.getLanguagedata();
	}
	public boolean insertFilm(String title, String desc, int language_id) {
		// TODO Auto-generated method stub
		return dao.insertFilm(title, desc, language_id);
	}
	public Film updateFilm(int id) {
		// TODO Auto-generated method stub
		return dao.updateFilm(id);
	}
	public boolean updateFileNew(String title, String desc, int name, int id) {
		// TODO Auto-generated method stub
		return dao.updateFileNew(title, desc, name, id);
	}

}
