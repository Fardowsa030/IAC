package iac.hu.shop.model;

import iac.hu.shop.persistence.AanbiedingService;
import iac.hu.shop.persistence.AccountService;
import iac.hu.shop.persistence.AdresService;
import iac.hu.shop.persistence.CategorieService;
import iac.hu.shop.persistence.KlantService;
import iac.hu.shop.persistence.OrderService;
import iac.hu.shop.persistence.OrderregelService;
import iac.hu.shop.persistence.ProductService;


public class ServiceProvider {
	private static CategorieService categorieService = new CategorieService();
	private static ProductService productService = new ProductService();
	private static AccountService accountService = new AccountService();
	private static OrderService orderService = new OrderService();
	private static OrderregelService orderRegelService = new OrderregelService();
	private static KlantService klantService = new KlantService();
	private static AdresService adresService = new AdresService();
	private static AanbiedingService aanbiedingService = new AanbiedingService();



	public static CategorieService getCategorieService() {
		return categorieService;
	}
	
	public static ProductService getProductService() {
		return productService;
	}
	
	public static AccountService getAccountService() {
		return accountService;
	}
	
	public static OrderService getOrderService() {
		return orderService;
	}
	
	public static OrderregelService getOrderregelService() {
		return orderRegelService;
	}
	
	public static KlantService getKlantService() {
		return klantService;
	}
	
	public static AdresService getAdresService() {
		return adresService;
	}

	public static AanbiedingService getAanbiedingService() {
		return aanbiedingService;
	}
}
