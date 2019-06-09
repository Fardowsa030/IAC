package iac.hu.shop.persistence;

import java.sql.SQLException;

import iac.hu.shop.model.Account;

public interface AccountDao {
	
	public boolean validation(String gebruikersnaam,String wachtwoord) throws SQLException;
	public Account getAccount(String gebruikersnaam) throws SQLException;
	public Account getAccountById(int id) throws SQLException;
	

}
