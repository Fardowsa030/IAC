package iac.hu.shop.persistence;

import java.sql.SQLException;

import iac.hu.shop.model.Klant;

public interface KlantDao {
	
	public Klant KlantById(int id) throws SQLException;
	public boolean save(Klant klant) throws SQLException;
	public int createUniqueIdKlant();

}
