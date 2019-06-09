package iac.hu.shop.persistence;

import java.sql.SQLException;
import iac.hu.shop.model.Klant;

public class KlantService {
	
	private KlantDao kdao = new KlantDaoImpl();
	 
	 public boolean save (Klant klant) throws SQLException {
			return kdao.save(klant);
		}
	 public int uniqueKlant() {
		 return kdao.createUniqueIdKlant(); // functie maken voor unique 1 functie voor alle
	 }
	 
	 public Klant KlantById(int id) throws SQLException{
		 return kdao.KlantById(id);
	 }

}
