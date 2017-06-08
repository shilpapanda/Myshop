package com.myshop.MyshopBackend.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.MyshopBackend.model.Product;

@SuppressWarnings("deprecation")
@Repository("productDAO")
public class ProductDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	public ProductDAO(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		System.out.println("ProductDAO Object Created");
	}
	
	@Transactional
	public void insertProduct(com.myshop.MyshopBackend.model.Product product)
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
	}
	
	@Transactional 
	public void deleteProduct(int prodid)
	{
		Session session=sessionFactory.getCurrentSession();
		Product product=(Product)session.get(Product.class,prodid);
		session.delete(product);
	}
	
	@SuppressWarnings("rawtypes")
	public List<Product> retrieveProduct()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
		@SuppressWarnings("unchecked")
		List<Product> list=(List<Product>)query.list();
		session.close();
		return list;
	}
	
	public Product getProduct(int prodid)
	{
		Session session=sessionFactory.openSession();
		Product product=(Product)session.get(Product.class,prodid);
		session.close();
		return product;
	}
	
	@Transactional
	public void updateProduct(Product product)
	{
		Session session=sessionFactory.getCurrentSession();
		session.update(product);
	}
}
