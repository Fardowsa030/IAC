package iac.hu.shop.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import iac.hu.shop.model.Adres;
import iac.hu.shop.model.Bestelling;
import iac.hu.shop.model.Bestellingsregel;
import iac.hu.shop.model.Klant;


public class OrderDaoImpl extends OracleBaseDao implements OrderDao {
	Connection c = super.getConnection();
	
	
	public Bestelling getOrderById(int id) throws SQLException {
		Bestelling bestelling = null;
		PreparedStatement ps = c.prepareStatement("SELECT * FROM orders where id=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		 while (rs.next()) {
			 OrderregelDao odao = new OrderregelDaoImpl();
			 List<Bestellingsregel> regels = odao.GetBestellingenByID(rs.getInt("id"));
			 KlantDao kdao = new KlantDaoImpl();
			 Klant klant = kdao.KlantById(rs.getInt("klantid"));
			 bestelling = new Bestelling(
					 rs.getInt("id"),
					 rs.getString("aanvraagdatum"),
					 rs.getInt("klantid"));
			 bestelling.setRegels(regels);
			 bestelling.setKlant(klant);
					 
			
		 }
		

		return bestelling;
	}
	
	public boolean saveAccount(Bestelling bestelling) throws SQLException {
		PreparedStatement ps = c.prepareStatement("insert into orders (id,aanvraagdatum,klantid)values(?, ?, ?)");
		ps.setInt(1, bestelling.getId());
		ps.setString(2, bestelling.getOrderDatum());
		ps.setInt(3, bestelling.getKlantID());
		int count = ps.executeUpdate();
		
		if (count > 0) {
			return true;
		}
		return false;

	}
	
	public boolean saveGast(Bestelling bestelling) throws SQLException {
		PreparedStatement ps = c.prepareStatement("insert into orders (id,aanvraagdatum,klantid)values(?, ?, ?)");
		ps.setInt(1, bestelling.getId());
		ps.setString(2, bestelling.getOrderDatum());
		ps.setInt(3, bestelling.getKlantID());
		int count = ps.executeUpdate();
		
		if (count > 0) {
			return true;
		}
		return false;

	}
	
	
	 public int createUniqueIDOrder() {
	        try {
	            String queryText =  "SELECT MAX(ID) + 1 as newID " +
	                    "FROM ORDERS";

	            PreparedStatement stmt = conn.prepareStatement(queryText);

	            ResultSet result = stmt.executeQuery();

	            result.next();

	            int id = result.getInt("newID");
	            System.out.println(id);
	            return id;
	        }
	        catch(SQLException e) {
	            e.printStackTrace();
	            return 0;
	        }//
	    }
	

}
