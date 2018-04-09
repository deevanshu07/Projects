package com.soft.product;

import java.util.List;

import javax.ejb.Local;

import com.soft.login.Product;

@Local
public interface ProductSessionBeanLocal 
{
	public List allProducts();
	public String deleteProduct(String productId);
	public String addItem(Product product); 

}
