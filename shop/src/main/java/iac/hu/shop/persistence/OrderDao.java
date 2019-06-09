package iac.hu.shop.persistence;

import java.sql.SQLException;

import iac.hu.shop.model.Bestelling;

public interface OrderDao {
	
	public boolean saveAccount(Bestelling bestelling) throws SQLException;
	public boolean saveGast(Bestelling bestelling) throws SQLException;
	public int createUniqueIDOrder();
	public Bestelling getOrderById(int id) throws SQLException;
	
	

}
