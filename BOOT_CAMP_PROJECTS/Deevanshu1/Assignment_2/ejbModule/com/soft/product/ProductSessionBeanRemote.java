package com.soft.product;

import java.util.List;

import javax.ejb.Remote;

import com.soft.login.Product;

@Remote
public interface ProductSessionBeanRemote 
{
	public List allProducts();
	public String deleteProduct(String productId);
	public String addItem(Product product); 
 

}