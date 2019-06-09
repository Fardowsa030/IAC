package iac.hu.shop.persistence;

import java.sql.SQLException;
import java.util.List;


import iac.hu.shop.model.Product;

public class ProductService {
	
	 private ProductDao PDAO = new ProductDaoImpl();
	 
	 public List<Product> findbyCategorie(int id) throws SQLException {
			return PDAO.GetAllProducts(id);
		}
	 
	 public List<Product> getAll() throws SQLException {
			return PDAO.GetAll();
		}
	 
	 public List<Product> NewProducts() throws SQLException{
		 return PDAO.NewProducts();
	 }
	 
	 public Product findbyId(int id) throws SQLException {
			return PDAO.GetProductById(id);
		}
	 
	 public boolean delete(Product product) throws SQLException{
		 return PDAO.delete(product);
	 }
	 
	 public boolean save(Product product) throws SQLException{
		 return PDAO.save(product);
	 }
	 
	 public boolean update(Product product) throws SQLException{
		 return PDAO.update(product);
	 }
	 
	 public int createUniqueIDProduct() {
		 return PDAO.createUniqueIDProduct();
	 }



	 
	 
	 
	 

}
