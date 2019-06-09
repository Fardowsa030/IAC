package iac.hu.shop.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import iac.hu.shop.model.Bestellingsregel;
import iac.hu.shop.model.Categorie;
import iac.hu.shop.model.Product;

public class OrderregelDaoImpl extends OracleBaseDao implements OrderregelDao {
	
Connection c = super.getConnection();

		public List<Bestellingsregel> GetBestellingenByID(int id) throws SQLException {
			ArrayList<Bestellingsregel> bestellingregels = new ArrayList<Bestellingsregel>(); 
			PreparedStatement ps = c.prepareStatement("SELECT * FROM orderregels where orders_id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			 while (rs.next()) {
				 Bestellingsregel regel = new Bestellingsregel(
						 rs.getInt("id"),
						 rs.getInt("aantal"),
						 rs.getInt("leverprijs"),
						 rs.getInt("producten_id"),
						 rs.getInt("orders_id"));
				 bestellingregels.add(regel);
			 }
			  return bestellingregels;				
			}
	
	public boolean save(Bestellingsregel bestellingsregel) throws SQLException {
		PreparedStatement ps = c.prepareStatement("insert into orderregels (id,aantal,leverprijs,producten_id,orders_id)values(?, ?, ?,?,?)");
		ps.setInt(1, bestellingsregel.getId());
		ps.setInt(2, bestellingsregel.getAantal());
		ps.setInt(3, bestellingsregel.getLeverprijs());
		ps.setInt(4, bestellingsregel.getProductID());
		ps.setInt(5, bestellingsregel.getBestellingID());
		int count = ps.executeUpdate();
		
		if (count > 0) {
			return true;
		}
		return false;

	}
	
	 public int createUniqueIDOrderRegel() {
	        try {
	            String queryText =  "select max(id) + 1 as newID " +
	                    "from orderregels";

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
	        }
	    }



}
