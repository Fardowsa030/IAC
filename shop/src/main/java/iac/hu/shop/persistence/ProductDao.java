package iac.hu.shop.persistence;

import java.sql.SQLException;
import java.util.List;

import iac.hu.shop.model.Product;

public interface ProductDao {
	
	public List<Product> GetAllProducts(int id) throws SQLException;
	public Product GetProductById(int id) throws SQLException;
	public boolean save(Product product) throws SQLException;
	public boolean update(Product product) throws SQLException;
	public boolean delete(Product product) throws SQLException;
	public int createUniqueIDProduct();
	public List<Product> NewProducts() throws SQLException;
	public List<Product> GetAll() throws SQLException;
	

}
