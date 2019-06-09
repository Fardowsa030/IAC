package iac.hu.shop.persistence;

import java.sql.SQLException;
import java.util.List;

import iac.hu.shop.model.Categorie;

public interface CatergorieDao {
	public List<Categorie> GetCategories() throws SQLException;
	public Categorie GetCategorie(int id) throws SQLException;

}
