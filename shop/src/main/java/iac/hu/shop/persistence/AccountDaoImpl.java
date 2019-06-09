package iac.hu.shop.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import iac.hu.shop.model.Account;
import iac.hu.shop.model.Klant;

public class AccountDaoImpl extends OracleBaseDao implements AccountDao {

	Connection c = super.getConnection();
	
	
	public boolean validation(String email, String wachtwoord) throws SQLException {
		PreparedStatement ps = c.prepareStatement("SELECT * FROM account where email=? and wachtwoord=?");
		ps.setString(1, email);
		ps.setString(2, wachtwoord);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			
			return true;
		
		}
		return false;
		
		
		
		
		
	}
	
	
	
	
	public Account getAccount(String email) throws SQLException {
		Account account = null;
		PreparedStatement ps = c.prepareStatement("SELECT * FROM account where email=?");
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			 KlantDao kdao = new KlantDaoImpl();
			 Klant klant = kdao.KlantById(rs.getInt("id"));
			 account= new Account(
					 rs.getInt("id"),
					 rs.getDate("openDatum"),
					 rs.getString("isActief"),
					 rs.getString("factuurAdres"),
					 rs.getString("email"),
					 rs.getString("wachtwoord"),
					 klant);
		 }
		

	    return account;
	}
	
	public Account getAccountById(int id) throws SQLException {
		Account account = null;
		PreparedStatement ps = c.prepareStatement("SELECT * FROM account where id=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			 KlantDao kdao = new KlantDaoImpl();
			 Klant klant = kdao.KlantById(rs.getInt("id"));
			 account= new Account(
					 rs.getInt("id"),
					 rs.getDate("openDatum"),
					 rs.getString("isActief"),
					 rs.getString("factuurAdres"),
					 rs.getString("email"),
					 rs.getString("wachtwoord"),
					 klant);
		 }
		

	    return account;
	}
	

	
	
}
