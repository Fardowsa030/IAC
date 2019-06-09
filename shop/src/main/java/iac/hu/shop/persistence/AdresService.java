package iac.hu.shop.persistence;

import java.sql.SQLException;
import iac.hu.shop.model.Adres;

public class AdresService {
	
 private AdresDao ADAO = new AdresDaoImpl();
	 
	 public boolean save(Adres adres) throws SQLException {
			return ADAO.save(adres);
		}
	 
	 public int uniqeIDAdres() {
		 return ADAO.createUniqueIDAdres();
	 }

}
