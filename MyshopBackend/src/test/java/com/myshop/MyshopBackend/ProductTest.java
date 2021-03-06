package com.myshop.MyshopBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myshop.MyshopBackend.dao.*;
import com.myshop.MyshopBackend.model.*;

@SuppressWarnings("unused")
public class ProductTest 
{
	@SuppressWarnings("resource")
	public static void main(String arg[])
	{
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.myshop.MyshopBackend");
		context.refresh();
		
		
		ProductDAO productDAO=(ProductDAO)context.getBean("productDAO");
		
		//Inserting the Product
		
		Product product=new Product();
		
		product.setProdid(1008);
		product.setProdname("Samsung Galaxy 7");
		product.setCatid(1001);
		product.setSuppid(1002);
		product.setPrice(19000);
		product.setStock(10);
		product.setDesc("This is 4G Mobile");
		
		productDAO.insertProduct(product);
		
		System.out.println("Product Inserted:");
		
		/*Deleting the Product.
		
		productDAO.deleteProduct(1002);
		
		System.out.println("Deleted");*/
		
		/* Retrieving the Product 
		 * 
		 * 
		 
		
		List<Product> list=productDAO.retrieveProduct();
		
		for(Product p:list)
		{
			System.out.print(p.getProdid()+":::");
			System.out.print(p.getProdname()+":::");
			System.out.print(p.getCatid()+":::");
			System.out.print(p.getSuppid()+":::");
			System.out.print(p.getStock()+":::");
			System.out.print(p.getDesc()+":::");
			System.out.println(p.getPrice()+":::");
			
		}*/
		
		/*
		 * Updating the Product
		 */
		
		/*Product product=productDAO.getProduct(1003);
		
		product.setDesc("This is Simple Mobile with Camera Feature");
		product.setPrice(14000);
		product.setStock(20);
		
		productDAO.updateProduct(product);
		
		System.out.println("Product is Updated");
		
		*/
	}
}
