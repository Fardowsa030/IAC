package iac.hu.shop.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import iac.hu.shop.model.Adres;



public class AdresDaoImpl extends OracleBaseDao implements AdresDao {
	
	Connection c = super.getConnection();
	

	public Adres getAdresById(int id) throws SQLException {
		Adres adres = null;
		PreparedStatement ps = c.prepareStatement("SELECT * FROM leveradressen where id=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) { 
			adres = new Adres(
					 rs.getInt("id"),
					 rs.getString("postcode"),
					 rs.getString("straat"),
					 rs.getInt("huisnummer"),
					 rs.getString("plaats"));

		}
		return adres;
	}
	
	public boolean save(Adres adres) throws SQLException {
		PreparedStatement ps = c.prepareStatement("insert into leveradressen (id,postcode,straat,huisnummer,plaats)values(?,?,?,?,?)");
		ps.setInt(1, adres.getId());
		ps.setString(2, adres.getPostcode());
		ps.setString(3, adres.getStraat());
		ps.setInt(4, adres.getHuisnummer());
		ps.setString(5, adres.getPlaats());
		int count = ps.executeUpdate();
		
		if (count > 0) {
			return true;
		}
		return false;

	}
	
	public int createUniqueIDAdres() {
        try {
            String queryText =  "SELECT MAX(ID) + 1 as newID " +
                    "FROM LEVERADRESSEN";

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
