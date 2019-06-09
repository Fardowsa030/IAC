package iac.hu.shop.persistence;

import java.sql.SQLException;
import java.util.List;

import iac.hu.shop.model.Categorie;


public class CategorieService {
	
  private CatergorieDao CDAO = new CategorieDaoImpl();
	
  public List<Categorie> findAll() throws SQLException {
		return CDAO.GetCategories();
	}
  
	public Categorie findCategorie(int id) throws SQLException {
		return CDAO.GetCategorie(id);
	}

}
