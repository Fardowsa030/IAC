package iac.hu.shop.persistence;

import java.sql.SQLException;
import java.util.List;
import iac.hu.shop.model.Aanbieding;


public class AanbiedingService {
	
 private AanbiedingDao ADAO = new AanbiedingDaoImpl();
	 
	 public List<Aanbieding> getAanbiedingen() throws SQLException {
			return ADAO.getAanbiedingen();
		}
	 
	 public Aanbieding getAanbieding(int id) throws SQLException {
			return ADAO.getAanbieding(id);
		}
	 

}
