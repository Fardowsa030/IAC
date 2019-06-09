package iac.hu.shop.persistence;

import java.sql.SQLException;

import iac.hu.shop.model.Account;


public class AccountService {
	
	 private AccountDao ADAO = new AccountDaoImpl();
	 
	 public Account getDetailsAccount(String email) throws SQLException {
			return ADAO.getAccount(email);
		}
	 
	 public Account getAccountById(int id) throws SQLException {
			return ADAO.getAccountById(id);
		}
	 
	 public boolean validation(String email,String wachtwoord) throws SQLException {
			return ADAO.validation(email, wachtwoord);
		}

}
