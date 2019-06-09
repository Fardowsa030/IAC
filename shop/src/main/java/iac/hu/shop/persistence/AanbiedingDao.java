package iac.hu.shop.persistence;

import java.sql.SQLException;
import java.util.List;

import iac.hu.shop.model.Aanbieding;

public interface AanbiedingDao {
	
	public List<Aanbieding> getAanbiedingen() throws SQLException;
	public Aanbieding getAanbieding(int id) throws SQLException;

}
