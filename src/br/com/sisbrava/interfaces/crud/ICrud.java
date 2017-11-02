package br.com.sisbrava.interfaces.crud;

import java.util.List;

public interface ICrud {
	
	public void insert (Object object);
	
	public void update (Object object);
	
	public void delete (Object object);
	
	public List<Object> selectMultiplusObjects (String table);
	
}
