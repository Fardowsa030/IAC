package iac.hu.shop.persistence;

import java.sql.SQLException;
import iac.hu.shop.model.Bestellingsregel;

public class OrderregelService {
	
	private OrderregelDao ORDAO = new OrderregelDaoImpl();
	 
	 public boolean saveOrderRegel(Bestellingsregel bestellingsregel) throws SQLException {
			return ORDAO.save(bestellingsregel);
		}
	 
	 public int createIdOrderRegel() {
		 return ORDAO.createUniqueIDOrderRegel();
	 }

}
