package com.soft.product;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.soft.login.Product;

/**
 * Session Bean implementation class ProductSessionBean
 */
@Stateless
public class ProductSessionBean implements ProductSessionBeanRemote, ProductSessionBeanLocal {

	@PersistenceContext(unitName="TrainingUnit44")
	private EntityManager em;
	
    public ProductSessionBean() 
    {
    	
    }
	
	@Override
	public List allProducts() 
	{
	List<Product> productList= new ArrayList<Product>();
		String pQuery="from Product";
		Query query=em.createQuery(pQuery);
		productList=(ArrayList)query.getResultList();
		
		return productList;
	}
	@Override
	public String deleteProduct(String productId) 
	{
		Product deleteItem=(Product)em.find(Product.class, productId);
		em.remove(deleteItem);
		
		return "success";
	}
	@Override
	public String addItem(Product product) 
	{
		
		em.persist(product);
		return "success";
	}

}