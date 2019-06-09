package iac.hu.shop.persistence;


import java.sql.SQLException;

import iac.hu.shop.model.Adres;

public interface AdresDao {
	
	public Adres getAdresById(int id) throws SQLException;
	public boolean save(Adres adres) throws SQLException;
	public int createUniqueIDAdres();

}
