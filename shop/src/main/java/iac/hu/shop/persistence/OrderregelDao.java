package iac.hu.shop.persistence;

import java.sql.SQLException;
import java.util.List;

import iac.hu.shop.model.Bestellingsregel;

public interface OrderregelDao {
	
	public boolean save(Bestellingsregel bestellingsregel) throws SQLException;
	public int createUniqueIDOrderRegel();
	public List<Bestellingsregel> GetBestellingenByID(int id) throws SQLException;

}
