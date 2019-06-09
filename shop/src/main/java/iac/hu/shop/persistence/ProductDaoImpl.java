package iac.hu.shop.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import iac.hu.shop.model.Categorie;
import iac.hu.shop.model.Product;

public class ProductDaoImpl extends OracleBaseDao implements ProductDao {
	
	Connection c = super.getConnection();
	
	public List<Product> GetAllProducts(int id) throws SQLException {
		ArrayList<Product> allProducts = new ArrayList<Product>(); 
		PreparedStatement ps = c.prepareStatement("SELECT * FROM producten where categorie_id=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		 while (rs.next()) {
			 CatergorieDao c = new CategorieDaoImpl();
			 Categorie cat = c.GetCategorie(rs.getInt("categorie_id"));
			 Product product = new Product(
					 rs.getInt("id"),
					 rs.getString("naam"),
					 rs.getString("omschrijving"),
					 rs.getString("plaatje"),
					 rs.getDouble("prijs"),
					 cat);
			 allProducts.add(product);
		 }
		  return allProducts;				
		}
	
	public List<Product> GetAll() throws SQLException {
		ArrayList<Product> allProducts = new ArrayList<Product>(); 
		PreparedStatement ps = c.prepareStatement("SELECT * FROM producten");
		ResultSet rs = ps.executeQuery();
		 while (rs.next()) {
			 Product product = new Product(
					 rs.getInt("id"),
					 rs.getString("naam"),
					 rs.getString("omschrijving"),
					 rs.getString("plaatje"),
					 rs.getDouble("prijs"),
			         rs.getString("aanmaakdatum"));
			 
			 allProducts.add(product);
		 }
		  return allProducts;				
		}
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	LocalDate datum = LocalDate.now();
	
	public List<Product> NewProducts() throws SQLException {
		ArrayList<Product> newProducts = new ArrayList<Product>(); 
		PreparedStatement ps = c.prepareStatement("SELECT * FROM producten where categorie_id is null and aanmaakDatum=to_char(sysdate)");
		
		
		//ps.setString(1, dtf.format(datum));
		System.out.println(dtf.format(datum));
		ResultSet rs = ps.executeQuery();
		 while (rs.next()) {
			 Product product = new Product(
					 rs.getInt("id"),
					 rs.getString("naam"),
					 rs.getString("omschrijving"),
					 rs.getString("plaatje"),
					 rs.getDouble("prijs"));

			 newProducts.add(product);
		 }
		  return newProducts;				
		}
	
	

	public Product GetProductById(int id) throws SQLException {
		Product product = null; 
		PreparedStatement ps = c.prepareStatement("SELECT * FROM producten where id=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		 while (rs.next()) {
			product = new Product(
					 rs.getInt("id"),
					 rs.getString("naam"),
					 rs.getString("omschrijving"),
					 rs.getString("plaatje"),
					 rs.getDouble("prijs"));
					
			 
		 }
		  return product;				
		}
	
	
	
	public boolean update(Product product) throws SQLException {
		
		Connection conn = super.getConnection();
		
		String updateProduct = "update producten set naam = ?, omschrijving = ?, prijs = ?, plaatje = ?, aanmaakDatum = TO_DATE(sysdate) where id= ?";
		
		PreparedStatement pstmt1 = conn.prepareStatement(updateProduct);
		
		pstmt1.setString(1, product.getNaam());
		pstmt1.setString(2, product.getOmschrijving());
		pstmt1.setDouble(3, product.getPrijs());
		pstmt1.setString(4, product.getAfbeeldingTekst());
		pstmt1.setInt(5, product.getId());
		
		if (pstmt1.executeUpdate() > 0) {
			
			return true;
				
		}
		
		return false;
	}

	public boolean save(Product product) throws SQLException {
		
		Connection conn = super.getConnection();
		
		String saveReiziger = "insert into producten(id,naam,omschrijving,prijs,plaatje,aanmaakDatum)values(?, ?, ?, ?, ?,TO_DATE(sysdate))";
		
		PreparedStatement pstmt1 = conn.prepareStatement(saveReiziger);
		
		pstmt1.setInt(1, product.getId());
		pstmt1.setString(2, product.getNaam());
		pstmt1.setString(3, product.getOmschrijving());
		pstmt1.setDouble(4, product.getPrijs());
		pstmt1.setString(5, product.getAfbeeldingTekst());
		
		int count = pstmt1.executeUpdate();
		
		if (count > 0) {
			
			return true;
			
		}
		
		return false;
		
	}
	
public boolean delete(Product product) throws SQLException {
		
		Connection conn = super.getConnection();
		
		
		String deleteProduct = "delete from producten where id = ?";
		
		PreparedStatement pstmt1 = conn.prepareStatement(deleteProduct);
		
		pstmt1.setInt(1, product.getId());
		
		
		int count = pstmt1.executeUpdate();
		
		if (count > 0) {
	
			return true;
			
			
		}
		
		return false;
		
	}

public int createUniqueIDProduct() {
	        try {
	            String queryText =  "SELECT MAX(ID) + 1 as newID " +
	                    "FROM PRODUCTEN";

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
