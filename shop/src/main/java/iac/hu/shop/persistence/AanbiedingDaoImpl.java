package iac.hu.shop.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import iac.hu.shop.model.Aanbieding;
import iac.hu.shop.model.Product;

public class AanbiedingDaoImpl extends OracleBaseDao implements AanbiedingDao {
	
	Connection c = super.getConnection();
	
	public List<Aanbieding> getAanbiedingen() throws SQLException{
		ArrayList<Aanbieding> alleAanbiedingen = new ArrayList<Aanbieding>(); 
		PreparedStatement ps = c.prepareStatement("SELECT * FROM aanbieding");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			ProductDao pdao = new ProductDaoImpl();
			Product product = pdao.GetProductById(rs.getInt("producten_id"));
			Aanbieding aanbieding = new Aanbieding(
					 rs.getInt("id"),
					 rs.getDate("vandatum"),
					 rs.getDate("totdatum"),
					 rs.getInt("aanbiedingsprijs"),
					 rs.getString("reclametekst"),
					 product);
			alleAanbiedingen.add(aanbieding);
			
		}

		return alleAanbiedingen;

	}
	
	public Aanbieding getAanbieding(int id) throws SQLException{
        Aanbieding aanbieding = null;
		PreparedStatement ps = c.prepareStatement("SELECT * FROM aanbieding where producten_id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			ProductDao pdao = new ProductDaoImpl();
			Product product = pdao.GetProductById(rs.getInt("producten_id"));
			     aanbieding = new Aanbieding(
					 rs.getInt("id"),
					 rs.getDate("vandatum"),
					 rs.getDate("totdatum"),
					 rs.getInt("aanbiedingsprijs"),
					 rs.getString("reclametekst"),
					 product);
		
			
		}

		return aanbieding;

	}
	
	
}
