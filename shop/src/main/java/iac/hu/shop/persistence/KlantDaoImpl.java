package iac.hu.shop.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import iac.hu.shop.model.Adres;
import iac.hu.shop.model.Klant;


public class KlantDaoImpl extends OracleBaseDao implements KlantDao {

	Connection c = super.getConnection();
	
	public Klant KlantById(int id) throws SQLException {
		Klant klant = null;
		PreparedStatement ps = c.prepareStatement("SELECT * FROM klanten where id=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		 while (rs.next()) {
			 AdresDao adao = new AdresDaoImpl();
			 Adres adres = adao.getAdresById(rs.getInt("adres_id"));
			 klant= new Klant(
					 rs.getInt("id"),
					 rs.getString("voornaam"),
					 rs.getString("achternaam"),
					 rs.getString("tussenvoegsel"),
					 rs.getString("mobielenummer"),
					 rs.getDate("geboortedatum"),
					 adres,
					 rs.getString("email"));
		 }
		

		return klant;
	}
	
	public boolean save(Klant klant) throws SQLException {
		PreparedStatement ps = c.prepareStatement("insert into klanten(id,achternaam,voornaam,tussenvoegsel,email,geboortedatum,adres_id,mobielenummer)values(?,?,?,?,?,?,?,?)");
		ps.setInt(1, klant.getId());
		ps.setString(2, klant.getAchternaam());
		ps.setString(3, klant.getVoornaam());
		ps.setString(4, klant.getTussenvoegsel());
		ps.setString(5, klant.getEmail());
		ps.setDate(6, klant.getGeboortedatum());
		ps.setInt(7, klant.getAdresID());
		ps.setString(8, klant.getMobiel());
		int count = ps.executeUpdate();
		
		if (count > 0) {
			return true;
		}
		return false;

	}
	
	public int createUniqueIdKlant() {
        try {
            String queryText =  "SELECT MAX(ID) + 1 as newID " +
                    "FROM KLANTEN";

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
