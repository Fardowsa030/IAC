package iac.hu.shop.persistence;

import java.sql.SQLException;
import iac.hu.shop.model.Bestelling;



public class OrderService {
	
 private OrderDao ODAO = new OrderDaoImpl();
	 
	 public boolean saveOrderAccount(Bestelling bestelling) throws SQLException {
			return ODAO.saveAccount(bestelling);
		}
	 
	 public boolean saveOrderGast(Bestelling bestelling) throws SQLException {
			return ODAO.saveGast(bestelling);
		}
	 
	 public int createIdOrder() {
		 return ODAO.createUniqueIDOrder();
	 }
	 
	 public Bestelling getOder(int id) throws SQLException {
		 return ODAO.getOrderById(id);
	 }

}
//