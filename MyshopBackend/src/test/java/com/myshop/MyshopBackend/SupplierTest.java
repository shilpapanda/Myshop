package com.myshop.MyshopBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myshop.MyshopBackend.dao.SupplierDAO;
import com.myshop.MyshopBackend.model.Supplier;

public class SupplierTest 
{
	@SuppressWarnings("resource")
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.myshop.MyshopBackend");
		context.refresh();
		
		SupplierDAO supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
		
		List<Supplier> list=supplierDAO.retrieve();
		
		for(Supplier supplier:list)
		{
			System.out.print(supplier.getSuppid());
			System.out.print(supplier.getSuppname());
			System.out.println(supplier.getSuppaddr());
		}
		
	}
}
