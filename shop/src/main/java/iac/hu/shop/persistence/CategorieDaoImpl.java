package iac.hu.shop.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import iac.hu.shop.model.Categorie;



public class CategorieDaoImpl extends OracleBaseDao implements CatergorieDao {
	
	Connection c = super.getConnection();
	
	
	public List<Categorie> GetCategories() throws SQLException {
		List<Categorie> categories = new ArrayList<Categorie>(); 
		PreparedStatement ps = c.prepareStatement("SELECT * FROM categorie");
		ResultSet rs = ps.executeQuery();
		 while (rs.next()) {
			 Categorie cat = new Categorie(
					 rs.getInt("id"),
					 rs.getString("afbeelding"),
					 rs.getString("naam"),
					 rs.getString("omschrijving"));
			 
			 categories.add(cat);
					 
		 }
		  return categories;				
		}
	
	
	public Categorie GetCategorie(int id) throws SQLException {
		Categorie cat = null; 
		PreparedStatement ps = c.prepareStatement("SELECT * FROM categorie where id = ?");
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		 while (rs.next()) {
			 cat = new Categorie(
					 rs.getInt("id"),
					 rs.getString("afbeelding"),
					 rs.getString("naam"),
					 rs.getString("omschrijving"));
				
					 
		 }
		  return cat;				
		}

		
		

}
